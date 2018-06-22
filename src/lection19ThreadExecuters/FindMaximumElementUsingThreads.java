package lection19ThreadExecuters;

public class FindMaximumElementUsingThreads implements Runnable {
    int[] array;

    public FindMaximumElementUsingThreads(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int maxInt = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxInt < array[i]) {
                maxInt = array[i];
            }
        }
        System.out.println(maxInt + " " + Thread.currentThread().getName());
        ArrayMainClass.setMaxValues(maxInt);
    }
}
