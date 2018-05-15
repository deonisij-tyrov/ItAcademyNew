package lection03;
/*Напишите программу, которая циклически сдвигает элементы массива вправо на одну позицию, и печатает результат.
Цикличность означает, что последний элемент массива становится самым первым его элементом.*/

public class HomeTask1 {
    public static void run() {
        System.out.println("Дз1");

        String[] array = ArrayConsoleInput.getStringArrayFromConsole();
        String tmp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = tmp;

        System.out.println("Полученный массив");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
