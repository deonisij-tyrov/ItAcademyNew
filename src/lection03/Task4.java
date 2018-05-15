package lection03;

/*Создать массив из 4 случайных целых чисел из отрезка [10;99], вывести его на экран в строку.
   Определить и вывести на экран сообщение о том, является ли массив строго возрастающей последовательностью.
*/
public class Task4 {
    public static void run() {
        System.out.println("Задача 4");
        int[] intArray = new int[4];
        boolean growingArray = true;

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (10 + Math.random() * (100 - 10));
        }

        System.out.println("Полученный массив:");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
            if (i > 0) {
                if (intArray[i - 1] > intArray[i]) {
                    growingArray = false;
                }
            }
        }
        System.out.println("\nРастущий массив:" + growingArray);

    }
}
