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

        int[] massive1 = ArrayConsoleInput.getIntArrayFromConsole();
        int[] massive2 = ArrayConsoleInput.getIntArrayFromConsole();
        int[] resultMassive = new int[massive1.length + massive2.length];

        for (int i = 0; i < massive1.length; i++) {
            resultMassive[i] = massive1[i];
        }

        int lastElementForResultMassive = massive1.length;
        for (int i = 0; i < massive2.length; i++) {
            resultMassive[lastElementForResultMassive + i] = massive2[i];
        }

        for (int i = 0; i < resultMassive.length; i++) {
            System.out.println(resultMassive[i]);
        }

    }
}
