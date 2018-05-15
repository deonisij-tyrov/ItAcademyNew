package lection02;

import java.util.Scanner;

/*  Написать программу, вычисляющую корни квадратного уравнения вида ax ² + bx + c = 0, где a, b и c - вводимые пользователем из консоли данные.
    Учитывать только реальные корни (в случае отрицательного дискриминанта выводить сообщение пользователю).
    При решении создать и использовать следующие вынесенные функции:
    - функция isPositive, определяющая, является ли число положительным
    - функция isZero, определяющая, является ли число нулём
    - функция discriminant, вычисляющая дискриминант*/
public class HomeTask3 {
    public static void run() {
        System.out.println("Занятие 2. Задача 3");
        double a, b, c, d;
        System.out.println("Введите часла уравнения:");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        d = discriminant(a, b, c);
        if (isPositive(d)) {
            System.out.println("Уравнение не имеет решений");
        } else if (isZero(d)) {
            System.out.println("Ответ:" + (-1) * b);
        } else {
            double x1 = ((-1) * b + Math.sqrt(d)) / 2 * a;
            double x2 = ((-1) * b - Math.sqrt(d)) / 2 * a;
            System.out.println("Ответ:" + x1 + ", " + x2);
        }
    }

    private static double discriminant(double a, double b, double c) {
        return (Math.pow(b, 2) - (4 * a * c));
    }

    private static boolean isZero(double d) {
        return d == 0;
    }

    private static boolean isPositive(double d) {
        return d < 0;
    }
}
