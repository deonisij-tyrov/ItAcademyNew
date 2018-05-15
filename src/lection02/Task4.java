package lection02;

import java.util.Scanner;

/*    Написать программу, которая считывает число, месяц и год, введённые пользователем в виде трёх целых чисел.
      Программа должна определять, является ли введённая дата реальной и выводить результат.
      Использовать следующую информацию:
      Январь, март, май, июль, август, октябрь, декабрь - 31 день
      Апрель, июнь, сентябрь, ноябрь - 30 дней
      Февраль - 28 дней в обычный год, 29 дней в високосный*/
public class Task4 {
    public static void run() {
        System.out.println("Задача 4\nВведите три числа(дату через пробел)");
        Scanner scanner = new Scanner(System.in);
        boolean leapYear;
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        int maxDayInMonth;
        final int MAX_MONTH = 12;

        leapYear = HomeTask1.isLeapYear(year);
        maxDayInMonth = HomeTask1.getMaxDayInMonth(month, leapYear);

        if (day > 0 && day <= maxDayInMonth && month > 0 && month <= MAX_MONTH && year > 0) {
            System.out.println("Дата реальна");
        } else {
            System.out.println("Дата нереальна");
        }
    }
}