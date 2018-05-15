package lection03;

import java.util.Scanner;

/*Написать алгоритм расчета факториала , используя циклы (for и while).*/
public class Task10 {
    public static void run() {
        System.out.println("Задача 10");
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("факториал for:" + calculateTheFactorialUsingFor(number));
        System.out.println("факториал while:" + calculateTheFactorialUsingWhile(number));
    }

    static int calculateTheFactorialUsingFor(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    static int calculateTheFactorialUsingWhile(int n) {
        int result = 1;
        int i = 1;
        while (i <= n) {
            result = result * i;
            i++;
        }
        return result;
    }
}


