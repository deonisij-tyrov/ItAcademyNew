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
        int sizeMassive1 = scanner.nextInt();
        int sizeMassive2 = scanner.nextInt();
        System.out.println("Введите значение массива:");
        int[][] massive = new int[sizeMassive1][sizeMassive2];

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                massive[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Исходный массив");
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                System.out.print(massive[i][j] + " ");
            }
            System.out.println("");
        }

        int[] newMassive = linearize(massive);
        System.out.println("Итоговый массив");
        for (int i = 0; i < newMassive.length; i++) {
            System.out.print(newMassive[i] + " ");
        }
    }

    private static int[] linearize(int[][] massive) {
        int[] newMassive = new int[massive.length * massive[0].length];
        int newCountMassive = 0;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                newMassive[newCountMassive] = massive[i][j];
                newCountMassive++;
            }
        }
        return newMassive;
    }
}
