package lection19ThreadExecuters;

import lection04.Time.Time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTask {

    public static void main(String[] args) {
        int sleepSeconds;
        ExecutorService service = Executors.newSingleThreadExecutor();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Время сна:");
            sleepSeconds = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(sleepSeconds);
//                    System.out.printf("Я спал %d секунд", sleepSeconds);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            private int getSeconds() {
//                SleepTask;
//            }
//        });
//        service.shutdown();
    }
}




