import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

class Server {
    private static Date initializationDate = new Date();
    private static int port;
    private static InetAddress IPAddress;
    private static HashMap<Integer,CopyOnWriteArraySet<Characters>>clients = new HashMap<>();
    private static CopyOnWriteArraySet characters = new CopyOnWriteArraySet();
    private static DatagramSocket serverSocket;
    private static Gson gson = new Gson();
    private static Date date = new Date();
    private static SimpleDateFormat fDate = new SimpleDateFormat("dd.MM.yyy hh:mm:ss");

    public static void main(String[] args) throws Exception {
//        ccharacters.add(new Characters("kot",12,11.00));
//        ccharacters.add(new Characters("pes", 24, 11.5));
        serverSocket = new DatagramSocket(9876); //отправка пакетов байтовых массивов для транспорта сообщений
        byte[] receiveData = new byte[1024]; // полученное сообщение

        label:
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // входящее сообщениt
            serverSocket.receive(receivePacket);
            clients.putIfAbsent(port, new CopyOnWriteArraySet<>());
            IPAddress = receivePacket.getAddress();
            port = receivePacket.getPort();
            String[] command = new String(receivePacket.getData(), 0, receivePacket.getLength()).split(" ");
            String check = "";
            if(command[0].equals("remove")||command[0].equals("add")||command[0].equals("add_if_max")){
                check = command[1];
            }
            String element = check;
            System.out.println("RECEIVED: " + command);


            switch (command[0]) {
                case "add":
                  new Thread(()->add(element)).start();
                    break;

                case "show":
                    new Thread(Server::show).start();
                    System.out.println("show");
                    break;

                case "info":
                    try {
                        new Thread(Server::info).start();
                    }catch (java.lang.NullPointerException e){
                        System.out.println("pizdec");
                    }
                    break;


                case "remove":
                    new Thread(()->remove(element)).start();
                    break;


                case "exit":
                    break label;
            }
        }
    }


    /**
     * Функция отправки сообщения клиенту
     *
     * @param mesage текст сообщения
     */
    private static synchronized void sendmsg(String mesage) {
        try {
            byte[] sendData = new byte[1024]; // отправленное сообщение
            sendData = mesage.getBytes();
            DatagramPacket out = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функция добавления элемента в коллекцию
     *
     * @param element элемент
     */
    static void add(String element) {
        try {
            Characters characters = gson.fromJson(element, Characters.class);
            if (characters.getName() != null) {
                clients.get(port).add(characters);
            } else
                sendmsg("You can't add null element!");
        } catch (com.google.gson.JsonSyntaxException jx) {
            sendmsg("The strings describing the objects must be in the form of json!");
        }
    }

    private static void show() {

        ArrayList<Characters> set = new ArrayList<>(clients.get(port));
        Collections.sort(set);
        clients.replace(port, clients.get(port), new CopyOnWriteArraySet<>(set));
        sendmsg(clients.get(port).toString());
//            System.out.println(ccharacters.toString());
//            sendmsg(ccharacters.toString());
    }

    private static void info(){
        String inf = "Collection type: "+clients.get(port).getClass()+"\n"+"Element's class type: "+Characters.class+"\n"+
                "Date initialization: "+initializationDate+"\n"+"Collection size: "+clients.get(port).size();
        sendmsg(inf);

    }


    private static void remove(String element){
        Characters characters = null;
        try {
            characters = gson.fromJson(element, Characters.class);
        }catch (com.google.gson.JsonSyntaxException ex) {
            sendmsg("The strings describing the objects must be in the form of json!");
        }
        if (clients.get(port).contains(characters)){
            clients.get(port).remove(characters);
        }else {
            sendmsg("This element is not in collection!");
        }
    }
}