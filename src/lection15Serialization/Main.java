package lection15Serialization;

import lection15Serialization.task1.TestFiles;
import lection15Serialization.task1.TestStream;
import lection15Serialization.task2.Computer;
import lection15Serialization.task2.Keyboard;
import lection15Serialization.task2.Monitor;
import lection15Serialization.task2.Mouse;
import lection15Serialization.task3.EthAdapter;
import lection15Serialization.task3.Notebook;
import lection15Serialization.task3.Touchpad;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*1.Сравнить скорость чтения и записи 5 МБ символов при использовании классов буфиризированого и не буфиризированого символьного ввода вывода.*/
        System.out.println("задание 1");
        TestStream testStream = new TestStream(new File("src/lection15Serialization/task1/text"), new File("src/lection15Serialization/task1/text(2)"));
        StringBuilder sb = testStream.testRead();
        testStream.testBuffRead();
        testStream.testWrite(sb.toString());
        testStream.testBuffWrite(sb.toString());

        TestFiles testFiles = new TestFiles("src/lection15Serialization/task1/text", "src/lection15Serialization/task1/text(2)");
        List<String> list = testFiles.testRead();
        testFiles.testWrite(list);


/*2. Создать класс Computer. Добавить ему несколько полей, создать объект этого класса, сериализовать в файл.
Десериализовать объект из того же файла, вывести значения полей в консоль.*/
        System.out.println("задание 2");
        Computer computer = new Computer(new Keyboard("keyboard"), new Monitor("hp"), new Mouse("def11"));
        System.out.println(computer.toString());
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/lection15Serialization/fileObj");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Computer readComputer = null;
        try (FileInputStream fileInputStream = new FileInputStream("src/lection15Serialization/fileObj");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            readComputer = (Computer) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (readComputer != null) {
            System.out.println(readComputer.toString());
        }
/*3. Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad - также созданного класса со своими полями. 
Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.*/
        System.out.println("задание 3");
        Notebook notebook = new Notebook(new Monitor("4monitor"), new Touchpad("4touch"), new EthAdapter("name"));
        System.out.println(notebook.toString());
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/lection15Serialization/fileNotebook");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(notebook);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Notebook readNotebook = null;
        try (FileInputStream fileInputStream = new FileInputStream("src/lection15Serialization/fileNotebook");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            readNotebook = (Notebook) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (readNotebook != null) {
            System.out.println(readNotebook.toString());
        }
    }
}
