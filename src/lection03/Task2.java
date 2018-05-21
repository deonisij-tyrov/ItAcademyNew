package lection03;

/*Напишите программу, заносящую в массив первые 100 натуральных чисел, делящихся на 13 или на 17, и печатающую его.*/
public class Task2 {
    public static void run() {
        System.out.println("Задача 2");
        int[] array = new int[100];
        int numberElements = 1;
        for (int i = 0; i < array.length; i++) {
            while (true) {
                if (numberElements % 13 == 0 || numberElements % 17 == 0) {
                    array[i] = numberElements;
                    numberElements++;
                    break;
                }
                numberElements++;
            }
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
