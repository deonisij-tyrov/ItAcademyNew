package lection14;

import java.io.File;

public class ListDirectory {

    public void listAll(File file) {
        File[] files = file.listFiles();
        for(File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }else {
                System.out.println(f.getName());
                listAll(f);
            }
        }
    }
}
