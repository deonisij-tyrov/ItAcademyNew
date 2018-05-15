package lection02;
/*  Написать программу, которая считывает год, введённый пользователем, и определяет, является ли этот год високосным.
    Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100, то этот год не високосный, за исключением годов, делящихся на 400.
    Например: 
    1992 - високосный
    1900 - не високосный
    2000 - високосный*/

import java.util.Scanner;

public class Task3 {
    public static void run() {
        System.out.println("Задача 3");
        System.out.println("Введите год:");
        int year = new Scanner(System.in).nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.println("Не високосный");
            } else {
                System.out.println("Високосный");
            }
        } else {
            System.out.println("Не високосный");
        }
    }
}