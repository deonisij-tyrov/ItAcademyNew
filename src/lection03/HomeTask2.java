package lection03;
/*Написать программу, удаляющую все повторяющиеся целые числа из массива и печатающую результат.*/
public class HomeTask2 {
    public static void run() {
        System.out.println("Дз2");
        String[] array = ArrayConsoleInput.getStringArrayFromConsole();
        String[] withoutDuplicateMassive = new String[array.length];

        int withoutDuplicateCount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                withoutDuplicateMassive[withoutDuplicateCount] = array[i];
                withoutDuplicateCount++;
            }
        }
        withoutDuplicateMassive[withoutDuplicateCount] = array[array.length -1];

        for (int i = 0; i < withoutDuplicateMassive.length; i++) {
            if (withoutDuplicateMassive[i] != null) {
                System.out.println(withoutDuplicateMassive[i]);
            }
        }
    }
}
