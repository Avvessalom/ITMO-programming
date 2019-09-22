import com.google.gson.Gson;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


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
//        ccharacters.add(new Characters("pes", 24, 11.5));
        serverSocket = new DatagramSocket(9876); //отправка пакетов байтовых массивов для транспорта сообщений
        byte[] receiveData = new byte[1024]; // полученное сообщение


        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // входящее сообщениt
            serverSocket.receive(receivePacket);
            IPAddress = receivePacket.getAddress();
            port = receivePacket.getPort();
            clients.putIfAbsent(port, new CopyOnWriteArraySet<>());
            String[] command = new String(receivePacket.getData(), 0, receivePacket.getLength()).split(" ");
            String check = "";
            if(command[0].equals("remove")||command[0].equals("add")||command[0].equals("add_if_max")){
                check = command[1];
            }
            String element = check;
            System.out.println("RECEIVED: " + command[0]);


            switch (command[0]) {
                case "add":
//                    clients.get(port).add(new Characters("kot",12,11.00));
                    new Thread(()->add(element)).start();
                    break;

                case "show":
                    new Thread(Server::show).start();
                    System.out.println("show");
                    break;

                case "info":
                      new Thread(Server::info).start();
                    break;


                case "remove":
                    new Thread(()->remove(element)).start();
                    break;


                case "import":
                    importer(receivePacket);
                    break;

                case "save":
                    new Thread(()->{
                        try{
                            close();
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }).start();
                    break;

                case "exit":
                    new Thread(()->{
                        try{
                            close();
                        }catch(IOException e){
                            e.printStackTrace();
                            System.out.println("ошибка");
                        }
                    }).start();
                    break;

                default:
                    sendmsg("You entered the wrong command! Read the list of commands carefully!");
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
    private static void add(String element) {
        try {
            String name;
            String size;
            String location;
            CopyOnWriteArraySet characters = new CopyOnWriteArraySet();
            String[] ellement = element.split(",");
            if (ellement[0].contains("name")){name = ellement[1];}
            if (ellement[2].contains("size")){size = ellement[3];}
            if (ellement[4].contains("location")){location = ellement[5];}
                clients.get(port).add(characters);
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


    private static void importer(DatagramPacket rec){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Client" + port + ".xml")));
            while (true) {
                serverSocket.receive(rec);
                byte[] in = rec.getData();
                String ins = new String(in, 0, rec.getLength());
                if (ins.equals("stop") || ins.equals("Exception")) break;
                bufferedWriter.write(ins);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void close() throws IOException{
        String outputFile = "Client"+port+".json";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        bufferedWriter.write("{\n");
        clients.get(port).stream().forEach((x) -> {
            try {
                bufferedWriter.write("{ \n \"Characters\"" + ": \""+x.getName()+"\"" + ",\n" + "\"size\"" +": \""+x.getSize()+"\"" +
                        ",\n" + "\"location\"" + ": \""+x.getLocation()+"\"" + "\n}");
            }catch (IOException writeEx){ System.err.println("Output EXCEPTION during writing"); }
        });
        bufferedWriter.close();
    }

}