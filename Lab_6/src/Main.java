//import java.io.*;
//import java.util.*;
//import java.net.*;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * @author Eugene Lazurin R3136
// */
//
//public class Main {
//
//    private Date initializationDate = new Date();
//    private DatagramSocket socket;
//    private int port;
//    private InetAddress adress;
//    private CopyOnWriteArraySet characters = new CopyOnWriteArraySet();
//    private byte[] b = new byte[1024];
//
//    public void main(String s) throws FileNotFoundException {
//        SortedSet<Character> characters = new TreeSet<>();
//
//        System.out.println("You can use this commands: " +
//                "\n" + "                           add {element} - adds an item to your collection" +
//                "\n" + "                           info - shows type of collection, amount of elements, etc" +
//                "\n" + "                           show - shows all items of collection" +
//                "\n" + "                           remove {element} - deletes this element from your collection" +
//                "\n" + "                           remove_lower {element} - deletes all elements lower than this" +
//                "\n" + "                           clear - clears all elements from your collection" +
//                "\n" + "                           exit - close application" +
//                "\n" + "                           import {path} - import elements from the file" +
//                "\n" + "                           save {path} - save elements in the file111");
//
//
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            public void run(){
//                try {
//                    close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//        int server_port = Integer.parseInt(s);
//        String[] command;
//
//
//        try {
//            socket = new DatagramSocket(server_port);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        label:
//        while (true) {
//
//            try {
//                DatagramPacket packet = new DatagramPacket(b, b.length);
//                socket.receive(packet);
//                byte[] data = packet.getData();
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(b, b.length, address, port);
//                command = new String(data, 0, packet.getLength()).split("");
//                String check ="";
//                if (command[0].equals("add")||command[0].equals("remove")){
//                    check = command[1];
//                }
//
//
////                if (command.contains("{") & command.contains("}")) {
////
////                    argue = command.substring(command.indexOf("{") + 1, command.indexOf("}"));
////                    newCommand = command.substring(0, command.indexOf("{"));
////
////                } else {
////                    newCommand = command;
////                }
//                String element = check;
//                switch (command[0]) {
//                    case "add":
//                    case "Add":
//                        //Commands.add(argue, characters);
//                        new Thread(()->add(element)).start();
//                        break;
//
//                    case "show":
//                    case "Show":
//                        Commands.show(characters);
//                        break;
//
//                    case "info":
//                    case "Info":
//
////                        Commands.info(characters);
//                        break;
//
//                    case "clear":
//                    case "Clear":
//
////                        Commands.clear(characters);
//                        break;
//
//                    case "remove":
//                    case "Remove":
//                    case "delete":
//                    case "Delete":
//
////                        Commands.delete(argue, characters);
//                        break;
//
//                    case "remove_lower":
//
////                        Commands.remove_lower(argue, characters);
//                        break;
//
//                    case "exit":
//                    case "Exit":
//
////                        Commands.exit();
//                        break label;
//
//                    case "import":
//                    case "Import":
////                        Commands.importer(argue, characters);
//                        break;
//
//                    case "save":
//                    case "Save":
//
////                        Commands.save(argue,characters);
//                        break;
//
//                    default:
//                        System.out.println("You entered the wrong command! Read the list of commands carefully!");
//                        break;
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//
//        }
//    }
//    private void add(String element) {
//        try {
//            Characters characters = gson.fromJson(element, Characters.class);
//            if (characters.getName() != null) {
//                clients.get(port).add(characters);
//            }else
//                sender("You can't add null element!");
//        }catch (Exception e){e.printStackTrace();}
//
//
//
//        private synchronized void sender(String msg){
//            try {
//                byte[] nb = msg.getBytes();
//                DatagramPacket out = new DatagramPacket(nb, nb.length, adress, port);
//                socket.send(out);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
