package lection14;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        FileToConsole toConsole = null;
        /*1. Задан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.*/
        //c:\ide\ClassProperties.txt
        System.out.println("_______________\nВведите полный путь к файлу");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            toConsole = new FileToConsole("src"+File.separator+"lection14"+File.separator+"ClassProperties.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*1. Задан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.*/
//        System.out.println("________________задача1");
//        toConsole.printAll();

        /*2. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.*/
//        System.out.println("________________задача2");
//        toConsole.wordsVowelsFirst();

        /*3. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного слова совпадает с первой буквой следующего слова*/
//        System.out.println("________________задача3");
//        toConsole.lastFirstLetter();

        /*4. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.*/
//        System.out.println("________________задача4");
//        toConsole.maxNumeralInLine();

        /*5. Записать в двоичный файл 20 случайных чисел типа int. Прочитать записанный файл, распечатать числа и их среднее арифметическое.*/
//        BinaryFile wf = new BinaryFile("src\\lection14\\BinaryFile");
//        wf.writeBinaryData();
//        wf.readBinaryData();

        /*6 Вывести список файлов и каталогов выбранного каталога на диске с учетом вложенности директориев. Для этого использовать рекурсию (пример рекурсии тут и тут).*/
        ListDirectory listDirectory = new ListDirectory();
        listDirectory.listAll(new File("src"));

        /*7. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки. */
//        ReverseJava reverseJava = new ReverseJava("src\\lection14\\Main.java", "src\\forLection14\\ReversCod");
//        reverseJava.revers();


    }
}
