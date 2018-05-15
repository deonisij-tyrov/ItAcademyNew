package lection02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  Имеются три числа - день, месяц и год, вводимые пользователем с консоли.
    Вывести дату следующего дня в формате "День.Месяц.Год".
    Учесть переход на следующий месяц, а также следующий год.
    Форматирование строки "День.Месяц.Год" вынести в отдельную функцию.*/
public class HomeTask1 {
    public static void run() {
        System.out.println("Занятие 2. Задача 1");
        String date = "00.00.00";
        boolean leapYear;
        int day;
        int month;
        int year;
        int maxDayInMonth;
        final int MAX_MONTH = 12;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {
            date = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] dateParse = readDate(date);
        day = Integer.parseInt(dateParse[0]);
        month = Integer.parseInt(dateParse[1]);
        year = Integer.parseInt(dateParse[2]);

        leapYear = isLeapYear(year);
        maxDayInMonth = getMaxDayInMonth(month, leapYear);

        if (day + 1 > maxDayInMonth) {
            day = 1;
            month++;
            if (month > MAX_MONTH) {
                month = 1;
                year = year + 1;
            }
        } else {
            day = day + 1;
        }
        System.out.println(day + "." + month + "." + year);
    }

    /*Определение даты*/
    private static String[] readDate(String date) {
        String[] dateParse = date.split("\\.");
        return dateParse;
    }

    /*проверка высокосный ли год*/
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /*Определение количества дней в месяце*/
    public static int getMaxDayInMonth(int month, boolean leapYear) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (leapYear) {
                    return 29;
                } else {
                    return 28;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return 0;
    }

}
