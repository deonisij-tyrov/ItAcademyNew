package lection19ThreadExecuters;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayMainClass {
    private static final int MAX_ARRAY_SIZE = 1000;
    private static int[] maxValuesFromThread;

    public static void main(String[] args) {
        findUsingThreads();
    }

    private static int[] randomIntArray() {
        int[] array = new int[(int) (Math.random() * MAX_ARRAY_SIZE)];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 300) + 1;
        }
        return array;
    }

    private static void findUsingThreads() {
        FindMaximumElementUsingThreads[] findMaximumElementUsingThreads = createThreadObjects();
        maxValuesFromThread = new int[findMaximumElementUsingThreads.length];
        ExecutorService executorService = Executors.newFixedThreadPool(findMaximumElementUsingThreads.length);
        for (FindMaximumElementUsingThreads thread : findMaximumElementUsingThreads) {
            executorService.submit(thread);
        }
        while (getMaxValuesArray()[9] == 0) {
        }
        int maxInt = 0;
        for (int i = 0; i < maxValuesFromThread.length; i++) {
            if (maxInt < maxValuesFromThread[i]) {
                maxInt = maxValuesFromThread[i];
            }
        }
        executorService.shutdown();
        System.out.println(maxInt + " итог");
    }

    private static FindMaximumElementUsingThreads[] createThreadObjects() {
        int[] array = randomIntArray();
        FindMaximumElementUsingThreads[] findMaximumElementUsingThreads;
        if (array.length < 10) {
            findMaximumElementUsingThreads = new FindMaximumElementUsingThreads[array.length];
            for (int i = 0; i < findMaximumElementUsingThreads.length; i++) {
                findMaximumElementUsingThreads[i] = new FindMaximumElementUsingThreads(new int[]{array[i]});
            }
        } else {
            findMaximumElementUsingThreads = new FindMaximumElementUsingThreads[10];
            int elements = array.length / findMaximumElementUsingThreads.length;
            int delta = array.length % findMaximumElementUsingThreads.length;
            int markForArray = 0;
            for (int i = 0; i < findMaximumElementUsingThreads.length; i++) {
                int[] pieceOfArray;
                if (delta > 0) {
                    pieceOfArray = Arrays.copyOfRange(array, markForArray, markForArray + elements + 1);
                    markForArray += elements + 1;
                    --delta;
                } else {
                    pieceOfArray = Arrays.copyOfRange(array, markForArray, markForArray + elements);
                    markForArray += elements;
                }
                findMaximumElementUsingThreads[i] = new FindMaximumElementUsingThreads(pieceOfArray);
            }
        }
        return findMaximumElementUsingThreads;
    }

    public synchronized static void setMaxValues(int maxValue) {
        for (int i = 0; i < maxValuesFromThread.length; i++) {
            if (maxValuesFromThread[i] == 0) {
                maxValuesFromThread[i] = maxValue;
                return;
            }
        }
    }

    private synchronized static int[] getMaxValuesArray() {
        return maxValuesFromThread;
    }
}
