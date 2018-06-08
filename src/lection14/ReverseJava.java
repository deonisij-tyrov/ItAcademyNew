package lection14;

import java.io.*;

public class ReverseJava {
    File inputFile;
    File outputFile;

    public ReverseJava(String inputPath, String outputPath) {
        this.inputFile = new File(inputPath);
        this.outputFile = new File(outputPath);
    }

    public void revers() {
        if (inputFile.exists() && outputFile.exists() && inputFile.isFile() && outputFile.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                while (br.ready()) {
                    bw.write(new StringBuilder(br.readLine()).reverse().toString() + "\n");
                }
                bw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
