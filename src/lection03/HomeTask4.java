package lection03;

import java.util.Scanner;

/*Написать функцию linearize, которая принимает в качестве параметра двумерный массив
и возвращает одномерный массив со всеми элементами двумерного.
*/
public class HomeTask4 {
    public static void run() {
        System.out.println("Дз4");
        System.out.println("Введите размер двумерного массива:");
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int sizeArray2 = scanner.nextInt();
        System.out.println("Введите значение массива:");
        int[][] array = new int[sizeArray1][sizeArray2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Исходный массив");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

        int[] newArray = linearize(array);
        System.out.println("Итоговый массив");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    private static int[] linearize(int[][] massive) {
        int[] newArray = new int[massive.length * massive[0].length];
        int newCountArray = 0;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                newArray[newCountArray] = massive[i][j];
                newCountArray++;
            }
        }
        return newArray;
    }
}
