package lection19ThreadExecuters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTask {

    public static void main(String[] args) {
        int finalSleepSeconds = 0;
        while (finalSleepSeconds == -1) {
            ExecutorService service = Executors.newSingleThreadExecutor();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Время сна:");
                finalSleepSeconds = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (finalSleepSeconds == -1) {
                return;
            }
            Integer finalSleepSeconds1 = finalSleepSeconds;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(finalSleepSeconds1);
                        System.out.printf("Я спал %d секунд", finalSleepSeconds1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            service.shutdown();
        }
    }
}




