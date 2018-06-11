package lection15Serialization;

import lection15Serialization.task2.Computer;
import lection15Serialization.task2.Keyboard;
import lection15Serialization.task2.Monitor;
import lection15Serialization.task2.Mouse;
import lection15Serialization.task3.Notebook;
import lection15Serialization.task3.Touchpad;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        TestStream testStream = new TestStream(new File("src/lection15Serialization/text"), new File("src/lection15Serialization/text(2)"));
//        StringBuilder sb = testStream.testRead();
//        testStream.testBuffRead();
//        testStream.testWrite(sb.toString());
//        testStream.testBuffWrite(sb.toString());

//        TestFiles testFiles = new TestFiles("src/lection15Serialization/text", "src/lection15Serialization/text(2)");
//        List<String> list = testFiles.testRead();
//        testFiles.testWrite(list);

//        Computer computer = new Computer(new Keyboard("keyboard"), new Monitor("hp"), new Mouse("def11"));
//        System.out.println(computer.toString());
//        try (FileOutputStream fileOutputStream = new FileOutputStream("src/lection15Serialization/fileObj");
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            objectOutputStream.writeObject(computer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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

        Notebook notebook = new Notebook(new Monitor("4monitor"),new Touchpad("4touch"));
        System.out.println(notebook.toString());
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/lection15Serialization/fileNotebook");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(notebook);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Notebook readNotebook = null;
        try (FileInputStream fileInputStream = new FileInputStream("src/lection15Serialization/fileNotebook");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
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
