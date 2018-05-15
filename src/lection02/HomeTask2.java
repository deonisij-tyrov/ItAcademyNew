package lection02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  Имеются два дома размерами a на b и c на d. Размеры вводятся польователем с консоли.
    Проверить, помещаются ли эти дома на участке размерами e на f.
    Стороны домов - параллельны сторонам участка, в остальном размещение может быть любым.*/
public class HomeTask2 {
    public static void run() {
        System.out.println("Занятие 2. Задача 2");
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите размеры дома1:");
            a = Integer.parseInt(bufferedReader.readLine());
            b = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Введите размеры дома2:");
            c = Integer.parseInt(bufferedReader.readLine());
            d = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Введите размеры участка:");
            e = Integer.parseInt(bufferedReader.readLine());
            f = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if ((a + c) > e || (b + d) > f) {
            if ((a + d) > e || (b + c) > f) {
                if ((a + c) > f || (b + d) > e) {
                    if ((a + d) > f || (b + c) > e) {
                        System.out.println("не помещаются");
                        return;
                    }
                }
            }
        }
        {
            System.out.println("помещаются");
        }
    }
}
