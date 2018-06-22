package lection19ThreadExecuters;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepScannerTask {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Время сна:");
                        int finalSleepSeconds = scanner.nextInt();

                        if (finalSleepSeconds == -1) {
                            return;
                        }
                        try {
                            TimeUnit.SECONDS.sleep(finalSleepSeconds);
                            System.out.printf("Я спал %d секунд\n", finalSleepSeconds);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        service.shutdown();
    }
}
