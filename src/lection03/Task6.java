package lection03;

import java.util.Scanner;

/*Написать метод equals, который определяет, равны ли между собой соответствующие элементы
2-х двумерных массивов.
*/
public class Task6 {
    public static void run() {
        System.out.println("Задача 6");
        System.out.println("Введите размер массива1:");
        Scanner scanner = new Scanner(System.in);
        int[][] array1 = new int[scanner.nextInt()][scanner.nextInt()];
        System.out.println("Введите размер массива2:");
        int[][] array2 = new int[scanner.nextInt()][scanner.nextInt()];

        System.out.println("Введите элементы массива1:");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Введите элементы массива2:");
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = scanner.nextInt();
            }
        }

        System.out.print(equals(array1, array2));
    }

    private static boolean equals(int[][] array1, int[][] array2) {
        if (array1.length != array2.length || array1[0].length != array2[0].length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
