//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;
///**
// * @author Eugene Lazurin R3136
// */
//class Commands {
//    private static Gson gson = new Gson();
//    private static Date date = new Date();
//    private static SimpleDateFormat fDate = new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
//
//    /**
//     * Функция добаления элемента в коллекцию
//     * @param element - аргумент
//     * @param characters - экземпляр коллекции
//     *
//     *                   в метод предавать порт и айпишник, а также элемент, работу с элементом, должно сработать.
//     *
//     */
//    static void add(String element, port,) {
//        try{Characters characters = gson.fromJson(element, Characters.class);
//            if (characters.getName() != null){
//                clients.get(port).add(characters);
//            }
//        }else
//            sendmsg("You can't add null element!");
//
//    /**
//     * Функция отображения всех элементов коллекции
//     * @param characters - экземпляр коллекции
//     */
//    static void show(SortedSet<Characters> characters) {
//
//        if (characters.size() == 0) {
//            System.out.println("This collection is empty :( Put some items!");
//        } else {
//            System.out.println("Your collection consists of: ");
//            for (Characters p : characters) {
//                System.out.println(p.getName());
//            }
//        }
//    }
//
//    /**
//     * Функция отображения информации о коллекции
//     * @param characters - экземпляр коллекции
//     */
//    static void info(SortedSet<Characters> characters) {
//        System.out.println("Collection type: " + characters.getClass() + "\n" + "Date of initialization: " + fDate.format(date));
//        System.out.println("Number of items: " + characters.size());
//    }
//
//    /**
//     * Функция удаления всех элементов коллекции
//     * @param characters - экземпляр коллекции
//     */
//    static void clear(SortedSet<Characters> characters) {
//        characters.clear();
//        System.out.println("You deleted all items!");
//    }
//
//
//    /**
//     * Функция удаления указанного элемента
//     * @param argue - аргумент
//     * @param characters - экземпляр коллекции
//     */
//    static void delete(String argue, SortedSet<Characters> characters) {
//        for (Characters p : characters) {
//
//            if (p.getName().equals(argue)) {
//                characters.remove(p);
//            }
//        }
//        System.out.println("Item " + argue + " was deleted!");
//    }
//
//    /**
//     * Функция удаления всех элементов коллекции, стоящих ранее по алфавиту
//     * @param argue - аргумент
//     * @param characters - экземпляр коллекции
//     */
//    static void remove_lower(String argue, SortedSet<Characters> characters) {
//        for (Characters p : characters) {
//            if (p.getName().compareTo(argue) < 0) {
//                characters.remove(p);
//            }
//        }
//        System.out.println("All items lower than this were deleted!");
//    }
//
//    /**
//     * Функция, завершающая работу приложения
//     */
//    static void exit() {
//        System.out.println("See you later :)");
//    }
//
//    /**
//     * Функция, сохраняющая коллекцию в файл
//     * @param argue - аргумент (путь к файлу)
//     * @param characters - экземпляр коллекции
//     */
//    static void save( String argue,SortedSet<Characters> characters){
//        if (argue == null)
//            throw new IllegalArgumentException("Way is empty!");
//        try {
//            File file2 = new File(argue); // создакм экземпляр файла
//            FileWriter fileReader = new FileWriter(file2); // поток который подключается к текстовому файлу
//            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); //соединяем BufferedWriter c FileWriter
//            bufferedWriter.write("{");
//            bufferedWriter.write("\n");
//            bufferedWriter.write(" \"Characters\":{");
//            bufferedWriter.write("\n");
//            for (Characters p : characters){
//                bufferedWriter.write("  \"Name\":\"" + p.getName() + "\",");
//                bufferedWriter.write("\n");
//            }
//            bufferedWriter.write("},");
//            bufferedWriter.flush();
//        }catch (java.io.IOException e){
//            e.printStackTrace();
//        }
//        System.out.println("The file was saved successfully!");
//
//    }
//
//
//
////    /**
////     * Функция, импортирующая данные из указанного файла
////     * @param argue - аргумент (путь к файлу)
////     * @param characters - экземпляр коллекции
////     * @throws FileNotFoundException - файл не найден
////     */
////    static void importer(String argue, SortedSet<Characters> characters) throws FileNotFoundException {
////        if (argue == null)
////            throw new IllegalArgumentException("Way is empty!");
////        File file2 = new File(argue);
////        FileReader fileReader = new FileReader(file2);
////        BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
////
////        String line;
////        try {while ((line = bufferedReader.readLine()) != null) {
////            if (line.contains("\"Name")) {
////                String name = line.substring(line.indexOf("\"") + 8, line.lastIndexOf("\""));
////                characters.add(new Characters(name));
////            }
////        }
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////
////        System.out.println("The file was imported successfully!");
////    }
//}
//
//}
