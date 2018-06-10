package lection15Serialization.task1;


import java.io.*;

public class TestStream {
    private File fileRead;
    private File fileWrite;
    private StringBuilder stringBuilder;

    public TestStream(File fileRead, File fileWrite) {
        this.fileRead = fileRead;
        this.fileWrite = fileWrite;
    }

    public StringBuilder testRead() {
        System.out.println("небуфиризированное чтение");
        stringBuilder = new StringBuilder();
        if (fileRead.exists() && fileRead.isFile()) {
            try (FileReader fileReader = new FileReader(fileRead);) {
                long t1 = System.nanoTime();
                int i = -1;
                while ((i=fileReader.read()) > -1) {
                    stringBuilder.append((char)i);
                }
                long t2 = System.nanoTime();
                System.out.println("lead time " + (t2 - t1));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("нет такого файла");
        }
        return stringBuilder;
    }

    public StringBuilder testBuffRead() {
        System.out.println("буфиризированное чтение");
        stringBuilder = new StringBuilder();
        if (fileRead.exists() && fileRead.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));) {
                long t1 = System.nanoTime();
                while (bufferedReader.ready()) {
                    stringBuilder.append(bufferedReader.read());
                }
                long t2 = System.nanoTime();
                System.out.println("lead time " + (t2 - t1));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("нет такого файла");
        }
        return stringBuilder;
    }

    public void testWrite(String s) {
        System.out.println("небуфиризированная запись");
        if (fileRead.exists() && fileRead.isFile()) {
            try (FileWriter fileWriter = new FileWriter(fileWrite)) {
                long t1 = System.nanoTime();
                fileWriter.write(s);
                fileWriter.flush();
                long t2 = System.nanoTime();
                System.out.println("lead time " + (t2 - t1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("нет такого файла");
        }
    }

    public void testBuffWrite(String s) {
        System.out.println("буфиризированная запись");
        if (fileRead.exists() && fileRead.isFile()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite))) {
                long t1 = System.nanoTime();
                bufferedWriter.write(s);
                bufferedWriter.flush();
                long t2 = System.nanoTime();
                System.out.println("lead time " + (t2 - t1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("нет такого файла");
        }
    }
}
