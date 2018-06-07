package lection14;

import java.io.*;

public class BinaryFile {
    File file;

    public BinaryFile(String fullPath) {
        this.file = new File(fullPath);
    }

    public void writeBinaryData() {
        try (OutputStreamWriter bf = new OutputStreamWriter(new FileOutputStream(file))) {
            for (int i = 0; i < 20; i++) {
                Double d = (Math.random() * 100) + 128;
                bf.write(d.intValue());
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBinaryData() {
        if (file.exists() && file.isFile()) {
            try (InputStreamReader bi = new InputStreamReader(new FileInputStream(file))) {
                int sum = 0;
                int i = 0;
                System.out.println("числа:");
                while (bi.ready()) {
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
