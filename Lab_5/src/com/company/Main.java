package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        String[] list = {"one", "two", "three", "fo"};
        try {
            File file = new File("C:\\Users\\Erwin Eugen Rommel\\Documents\\GitHub\\ITMO_programming_lab\\Lab_5\\Characters.txt");
            FileWriter fileReader = new FileWriter(file); // поток который подключается к текстовому файлу
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // соединяем FileWriter с BufferedWitter

            for (String s : list) {
                bufferedWriter.write(s + "\n");
            }

            bufferedWriter.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }




        ArrayDeque<Characters> characters = new ArrayDeque<>();
        Scanner scanner = new Scanner(file);
        Scanner sc = new Scanner(System.in);

            SortedSet<String> countrySet = new TreeSet<>();
            countrySet.add("Россия");
            countrySet.add("Франция");
            countrySet.add("Гондурас");
            countrySet.add("Кот-Д'Ивуар"); // любимая страна всех котов

            mInfoTextView.setText(countrySet.toString());
    }
}
