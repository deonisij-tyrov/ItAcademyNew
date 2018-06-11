package lection14;

import java.io.File;

public class ListDirectory {

    public void listAll(File file) {
        String t = " ";
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isFile()) {
                System.out.println(t + f.getName());
                listAll(f);
            } else {
                System.out.println("  "+f.getName());
                t+=t;
            }
        }
    }
}
