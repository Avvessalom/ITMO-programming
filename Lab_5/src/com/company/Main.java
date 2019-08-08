package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String argue = null, newCommand;
        String command;
        SortedSet<Characters> characters = new TreeSet<>();
        File file = new File("C:\\Users\\Erwin Eugen Rommel\\Documents\\GitHub\\ITMO_programming_lab\\Lab_5\\Characters"); // создакм экземпляр файла
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line1;
        try {
            while ((line1 = bufferedReader.readLine()) != null) {
                if (line1.contains("<Name")) {
                    String name = line1.substring(line1.indexOf("<") + 9 + 1, line1.lastIndexOf(">") - 10);
                    characters.add(new Characters(name));


                }
            }
        }catch (Exception a){
            a.printStackTrace();
        }









        System.out.println("You can use this commands: " +
                "\n" + "                           add {element} - adds an item to your collection" +
                "\n" + "                           info - shows type of collection, amount of elements, etc" +
                "\n" + "                           show - shows all items of collection" +
                "\n" + "                           remove {element} - deletes this element from your collection" +
                "\n" + "                           remove_lower {element} - deletes all elements lower than this" +
                "\n" + "                           clear - clears all elements from your collection" +
                "\n" + "                           exit - close application" +
                "\n" + "                           import {path} - import elements from the file" +
                "\n" + "                           save {path} - save elements in the file111");

        label:
        while (true) {

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(System.in); // поток чтения с консоли
                BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader); // соединяем FileReader с BufferedReader1


            System.out.println("Enter the command:");
            String line;
            line = bufferedReader1.readLine();
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
                case "Add":
                    Commands.add(argue, characters);
                    break;

                case "show":
                case "Show":
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

                case "import":
                case "Import":
                    Commands.importer(argue, characters);
                    break;

                case "save":
                case "Save":

                    Commands.save(argue,characters);
                    break;

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
