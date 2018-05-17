package lection03;

import java.util.Scanner;

public class ArrayConsoleInput {
    public static String[] getStringArrayFromConsole() {
        System.out.println("Введите размер массива:");
        Scanner scanner = new Scanner(System.in);
        int sizeMassive = scanner.nextInt();
        String[] array = new String[sizeMassive];

        System.out.println("Введите элементы массива");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }
        return array;
    }

    public static int[] getIntArrayFromConsole() {
//        System.out.println("Введите размер массива:");
//        Scanner scanner = new Scanner(System.in);
//        int sizeMassive = scanner.nextInt();
//        int[] array = new int[sizeMassive];
//
//        System.out.println("Введите элементы массива");
//        for (int i = 0; i < array.length; i++) {
//            array[i] = scanner.nextInt();
//        }
//        return array;
        return new int[]{12,45,78,56,13};
    }
}
