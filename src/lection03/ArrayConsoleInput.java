package lection03;

import java.util.Scanner;

public class ArrayConsoleInput {
    public static String[] getStringArrayFromConsole() {
        System.out.println("Введите размер массива:");
        Scanner scanner = new Scanner(System.in);
        int sizeMassive = scanner.nextInt();
        String[] massive = new String[sizeMassive];

        System.out.println("Введите элементы массива");
        for (int i = 0; i < massive.length; i++) {
            massive[i] = scanner.next();
        }
        return massive;
    }

    public static int[] getIntArrayFromConsole() {
        System.out.println("Введите размер массива:");
        Scanner scanner = new Scanner(System.in);
        int sizeMassive = scanner.nextInt();
        int[] massive = new int[sizeMassive];

        System.out.println("Введите элементы массива");
        for (int i = 0; i < massive.length; i++) {
            massive[i] = scanner.nextInt();
        }
        return massive;
    }
}
