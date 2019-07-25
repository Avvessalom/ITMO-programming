package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String argue = null, newCommand;
        String Command;
        File file = new File("C:\\Users\\Erwin Eugen Rommel\\Documents\\GitHub\\ITMO_programming_lab\\Lab_5\\Characters.txt"); // создакм экземпляр файла
        ArrayDeque<Characters> characters = new ArrayDeque<>();

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); // поток чтения с консоли
            FileWriter fileReader = new FileWriter(file); // поток который подключается к текстовому файлу

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // соединяем FileReader с BufferedReader
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); //соединяем BufferedWriter c FileWriter

            String line;
            while(!(line = bufferedReader.readLine()).equals("exit")){
                bufferedWriter.write(line+"\n"); // чтение и запись из командной строки с переносом
            }

            bufferedReader.close(); // закрываем поток
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }






    }
}
