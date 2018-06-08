package lection14;

import java.io.*;

public class BinaryFile {
    File file;

    public BinaryFile(String fullPath) {
        this.file = new File(fullPath);
    }

    public void writeBinaryData() {
        System.out.println("записали числа ");
        try (DataOutputStream bf = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < 20; i++) {
                Double d = (Math.random() * 100) + 128;
                System.out.print(d.intValue() + " ");
                bf.write(d.intValue());
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBinaryData() {
        if (file.exists() && file.isFile()) {
            try (DataInputStream bi = new DataInputStream(new FileInputStream(file))) {
                int sum = 0;
                int i = 0;
                System.out.println("\nчисла:");
                while (bi.available() > 0) {
                    int value = bi.read();
                    System.out.print(value + " ");
                    sum += value;
                    i++;
                }
                System.out.println("среднее значение - " + sum / i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
