package lection02;

import java.util.Scanner;

/*  Имеется целое число, вводимое пользователем с консоли. Это число - сумма денег в рублях.
    Вывести это число, добавив к нему слово "рубль" в правильном падеже ("рубль", "рублей", "рубля").
    a. Использовать конструкцию if-else.
    b. Модифицировать в switch в отдельном файле.*/
public class Task2 {
    public static void run() {
        System.out.println("Задача 2");
        System.out.println("Введите кол-во рублей:");
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.next();
        String ruble;

        if (readLine.length() > 1) {
            int forNumberCheck = Integer.parseInt(readLine.substring(readLine.length() - 2, readLine.length()));

            if (forNumberCheck <= 14 && forNumberCheck >= 11) {
                ruble = "рублей";
            } else {
                ruble = SwitchForTask2.switchDemo(Integer.valueOf(readLine.substring(readLine.length() - 1)));
            }
        } else {
            ruble = SwitchForTask2.switchDemo(Integer.valueOf(readLine));
        }
        System.out.println(readLine + " " + ruble);
    }
}
