package lection19ThreadExecuters;

public class ArrayMainClass {
    private static final int MAX_ARRAY_SIZE = 1000000;

    private static int[] array = randomIntArray();

    public static void main(String[] args) {
        SearchUsingThreads searchUsingThreads = new SearchUsingThreads(array);
        long timeThreadsStart = System.nanoTime();
        int maxElementUsingThreads = searchUsingThreads.findUsingThreads();
        long timeThreadsEnd = System.nanoTime();
        System.out.println("рузультат с потоками - " + maxElementUsingThreads);
        System.out.println("время - " + (timeThreadsEnd - timeThreadsStart));


        FindeMaximumElement findeMaximumElement = new FindeMaximumElement(array);
        long timeNormalStart = System.nanoTime();
        int maxElement = findeMaximumElement.getMaxElement();
        long timeNormalEnd = System.nanoTime();
        System.out.println("результат без потоков - " + maxElement);
        System.out.println("время - " + (timeNormalEnd - timeNormalStart));
    }


    private static int[] randomIntArray() {
//        int[] array = new int[(int) (Math.random() * MAX_ARRAY_SIZE) + 1];
        int[] array = new int[MAX_ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 300) + 1;
        }
        return array;
    }


}
