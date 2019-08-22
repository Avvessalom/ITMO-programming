import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;


class Client
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //чтение с клавиатуры
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        while (true) {
            try{
                String sentence = inFromUser.readLine();//чтение с клавиатуры
                String[] strings =sentence.split(" ");

                if (strings[0] == "import"){
                    if(strings.length == 2){
                        File file = new File(strings[1]);
                        if(!file.exists())
                            System.err.println("File does not exist!");
                        else if(!file.canRead())
                            System.err.println("File cannot read! Please grant read permission or choose another file.");
                        else {
                            String is = sentence;
                            new Thread(()->{
                                try {
                                    byte[] send = is.getBytes();
                                    DatagramPacket sendPacket = new DatagramPacket(send, send.length, IPAddress, 9876); // отправление команды с клавиатуры на сервер                                    channel.write(bbuf);
                                    clientSocket.send(sendPacket);
                                    String os;
                                    Scanner sc = new Scanner(new FileInputStream(file));
                                    while (sc.hasNext()) {
                                        os = sc.nextLine();
                                        byte[] send1 = is.getBytes();
                                        DatagramPacket sendPacket1 = new DatagramPacket(send1, send1.length, IPAddress, 9876); // отправление команды с клавиатуры на сервер                                    channel.write(bbuf);

                                        clientSocket.send(sendPacket1);
                                    }
                                    os = "stop";
                                    byte[] send2 = is.getBytes();
                                    DatagramPacket sendPacket2 = new DatagramPacket(send2, send2.length, IPAddress, 9876); // отправление команды с клавиатуры на сервер                                    channel.write(bbuf);

                                    clientSocket.send(sendPacket2);

                                } catch (FileNotFoundException fex) {
                                    System.out.println("File not founded");
                                    DatagramPacket sendPacket3 = new DatagramPacket("Exeption".getBytes(),"Exeption".getBytes().length, IPAddress, 9876);
                                    try {
                                        clientSocket.send(sendPacket3);
                                    } catch (IOException exxe) {
                                        System.err.println("Problem with sending!");
                                    }
                                } catch (IOException exe) {
                                    System.err.println("Problem with sending!");
                                }
                            }).start();
                        }
                    }else {System.err.println("Enter correct file name!");}
                }else {
                    String sout = sentence;
                    new Thread(() -> {
                        byte[] send = sout.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(send, send.length, IPAddress, 9876); // отправление команды с клавиатуры на сервер
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }



                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); // отправление команды с клавиатуры на сервер
                clientSocket.send(sendPacket);


                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); //получение пакета от сервера
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + "\n" + modifiedSentence);


                clientSocket.close();
            }catch (IOException e){e.printStackTrace();}
        }
}
}