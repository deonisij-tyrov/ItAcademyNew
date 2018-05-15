package lection03;

/*Определить сумму элементов целочисленного массива, расположенных между минимальным и максимальным значениями.*/
public class Task3 {
    public static void run() {
        System.out.println("Задача 3");
        int[] intArray = ArrayConsoleInput.getIntArrayFromConsole();
        int indexMin = 0;
        int indexMax = 0;
        int minIntFromArray = intArray[0];
        int maxIntFromArray = intArray[0];
        int sum = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > maxIntFromArray) {
                maxIntFromArray = intArray[i];
                indexMax = i;
            }
            if (intArray[i] < minIntFromArray) {
                minIntFromArray = intArray[i];
                indexMin = i;
            }
        }

        if (indexMax > indexMin) {
            for (int i = indexMin + 1; i < indexMax; i++) {
                sum += intArray[i];
            }
        } else {
            for (int i = indexMax + 1; i < indexMin; i++) {
                sum += intArray[i];
            }
        }

        System.out.println("Сумма = " + sum);
    }
}
