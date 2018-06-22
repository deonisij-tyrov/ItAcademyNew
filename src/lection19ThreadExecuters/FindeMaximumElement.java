package lection19ThreadExecuters;

public class FindeMaximumElement {
    int[] array;

    public FindeMaximumElement(int[] array) {
        this.array = array;
    }

    public Integer getMaxElement() {
        int maxInt = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxInt < array[i]) {
                maxInt = array[i];
            }
        }
        return maxInt;
    }
}
