package lection03;

/*  Заданы 2 массива целых чисел произвольной длины. 
    Написать программу, создающую третий массив, представляющий собой слияние 2-х заданных.

Пример:

1-й массив: {1, 2, 3, 4, 5}
2-й массив: {5, 6, 7}

Результат: {1, 5, 2, 6, 3, 7, 4, 5}*/
public class HomeTask3 {
    public static void run() {
        System.out.println("Дз3");

        int[] array1 = ArrayConsoleInput.getIntArrayFromConsole();
        int[] array2 = ArrayConsoleInput.getIntArrayFromConsole();
        int[] resultArray = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) {
            resultArray[i] = array1[i];
        }

        int lastElementForResultMassive = array1.length;
        for (int i = 0; i < array2.length; i++) {
            resultArray[lastElementForResultMassive + i] = array2[i];
        }

        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }

    }
}
