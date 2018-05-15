package lection03;

import java.util.Scanner;

/*Создать двухмерный квадратный массив, и заполнить его "бабочкой", т.е. таким образом:

1 1 1 1 1
0 1 1 1 0
0 0 1 0 0
0 1 1 1 0
1 1 1 1 1

Вывести его на экран, заменив 1 символом *, а 0 - пробелом.
*/
public class Task5 {
    public static void run() {
        System.out.println("Задача 5");
        System.out.println("Введите размер квадратного массива:");

        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        String[][] butterflyArray = new String[sizeArray][sizeArray];
        butterflyArray = addElementArray(butterflyArray);

        System.out.println("Массив бабочка:");
        printMass(butterflyArray);
        butterflyArray = changeMass(butterflyArray);

        System.out.println("Измененный массив:");
        printMass(butterflyArray);

    }

    private static void printMass(String[][] butterflyArray) {

        for (String[] strings : butterflyArray) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println("");
        }
    }

    private static String[][] addElementArray(String[][] butterflyArray) {
        int step = 0;
        for (int i = 0; i < butterflyArray.length; i++) {
            for (int j = 0; j < butterflyArray[i].length; j++) {
                if (j >= step && j <= butterflyArray.length - 1 - step) {
                    butterflyArray[i][j] = "1";
                } else {
                    butterflyArray[i][j] = "0";
                }
            }
            if ((butterflyArray.length - 1) / 2 <= i) {
                step--;
            } else {
                step++;
            }
        }
        return butterflyArray;
    }

    private static String[][] changeMass(String[][] butterflyArray) {
        for (int i = 0; i < butterflyArray.length; i++) {
            for (int j = 0; j < butterflyArray[i].length; j++) {
                if (butterflyArray[i][j].equals("0")) {
                    butterflyArray[i][j] = " ";
                } else {
                    butterflyArray[i][j] = "*";
                }
            }
        }
        return butterflyArray;
    }

}
