package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String argue = null, newCommand;
        String command;
        File file = new File("C:\\Users\\Erwin Eugen Rommel\\Documents\\GitHub\\ITMO_programming_lab\\Lab_5\\Characters.txt"); // создакм экземпляр файла
        SortedSet<Characters> characters = new TreeSet<>();




        System.out.println("You can use this commands: " +
                "\n" + "                           add {element} - adds an item to your collection" +
                "\n" + "                           info - shows type of collection, amount of elements, etc" +
                "\n" + "                           show - shows all items of collection" +
                "\n" + "                           remove {element} - deletes this element from your collection" +
                "\n" + "                           remove_lower {element} - deletes all elements lower than this" +
                "\n" + "                           clear - clears all elements from your collection" +
                "\n" + "                           exit - close application" +
                "\n" + "                           import {path} - import elements from the file");

        label:
        while (true) {

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(System.in); // поток чтения с консоли
                FileWriter fileReader = new FileWriter(file); // поток который подключается к текстовому файлу

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // соединяем FileReader с BufferedReader
                BufferedWriter bufferedWriter = new BufferedWriter(fileReader); //соединяем BufferedWriter c FileWriter


//                while (!(line = bufferedReader.readLine()).equals("exit")) {
//                    bufferedWriter.write(line + "\n"); // чтение и запись из командной строки с переносом
//                }
//
//                bufferedReader.close(); // закрываем поток
//                bufferedWriter.close();


            System.out.println("Enter the command:");
            String line;
            line = bufferedReader.readLine();
            command = line ;
            command = command.replaceAll("\\s+", "");

            if (command.contains("{") & command.contains("}")) {

                argue = command.substring(command.indexOf("{") + 1, command.indexOf("}"));
                newCommand = command.substring(0, command.indexOf("{"));

            } else {
                newCommand = command;
            }

            switch (newCommand) {
                case "add":

                    Commands.add(argue, characters);
                    break;

                case "show":

                    Commands.show(characters);
                    break;

                case "info":
                case "Info":

                    Commands.info(characters);
                    break;

                case "clear":
                case "Clear":

                    Commands.clear(characters);
                    break;

                case "remove":
                case "Remove":
                case "delete":
                case "Delete":

                    Commands.delete(argue, characters);
                    break;

                case "remove_lower":

                    Commands.remove_lower(argue, characters);
                    break;

                case "exit":
                case "Exit":

                    Commands.exit();
                    break label;

//                case "import":
//
//                    Commands.importer(argue, characters);
//                    break;

                default:
                    System.out.println("You entered the wrong command! Read the list of commands carefully!");
                    break;

            }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
