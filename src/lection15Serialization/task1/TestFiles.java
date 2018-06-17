package lection15Serialization.task1;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.LinkedList;
//import java.util.List;
//
//public class TestFiles {
//    private String fileRead;
//    private String fileWrite;
//
//    public TestFiles(String fileRead, String fileWrite) {
//        this.fileRead = fileRead;
//        this.fileWrite = fileWrite;
//    }
//
//    public List<String> testRead() {
//        System.out.println("Files чтение");
//        List<String> list = new LinkedList<>();
//        try {
//            long t1 = System.nanoTime();
//            list = Files.readAllLines(Paths.get(fileRead));
//            long t2 = System.nanoTime();
//            System.out.println("lead time " + (t2 - t1));
//            return list;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public void testWrite(List<String> list) {
//        System.out.println("Files запись");
//        try {
//            long t1 = System.nanoTime();
//            Files.write(Paths.get(fileWrite),list);
//            long t2 = System.nanoTime();
//            System.out.println("lead time " + (t2 - t1));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
