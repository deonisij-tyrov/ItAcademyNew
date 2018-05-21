package lection03;

import java.util.Scanner;

/*Имеется целое число, определить является ли это число простым, т.е. делится без остатка только на 1 и себя.*/
public class Task9 {
    public static void run() {
        System.out.println("Задача 9");
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.print("простое число:" + isNatural(number) + "\n");


    }

    private static boolean isNatural(int number) {
        double sqrtNumber = Math.sqrt(number);
        if (number > 1) {
            for (int i = 2; i <= sqrtNumber; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
