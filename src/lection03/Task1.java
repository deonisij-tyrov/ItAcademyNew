package lection03;

/*Напишите программу, которая печатает массив сначала в обычном порядке, затем в обратном.*/
public class Task1 {
    public static void run() {
        System.out.println("Задача 1");

        int[] intArray = ArrayConsoleInput.getIntArrayFromConsole();

        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = intArray.length - 1; i >= 0; i--) {
            System.out.print(intArray[i] + " ");
        }

    }
}
