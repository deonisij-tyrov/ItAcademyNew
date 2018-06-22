package lection19ThreadExecuters;

public class FindMaximumElementUsingThreads implements Runnable {
    int[] array;
    SearchUsingThreads searchUsingThreads;

    public FindMaximumElementUsingThreads(int[] array, SearchUsingThreads searchUsingThreads) {
        this.array = array;
        this.searchUsingThreads = searchUsingThreads;
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
        searchUsingThreads.setMaxValues(maxInt);
    }
}
