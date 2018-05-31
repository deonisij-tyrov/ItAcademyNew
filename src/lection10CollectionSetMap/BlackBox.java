package lection10CollectionSetMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class BlackBox implements Comparator<Integer> {
    private List<Integer> list = new ArrayList<>();

    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }

    public void addNumber(int number) {
        list.add(number);
        Collections.sort(list);
    }

    public Integer getMinElement(int n) {
        if (n > 0 && n <= list.size()) {
            return list.get(n - 1);
        } else {
            System.out.println("неверный номер минимального елемента");
            return null;
        }
    }

    public Integer getMaxElement(int n) {
        if (n > 0 && n <= list.size()) {
            return list.get(list.size() - n);
        } else {
            System.out.println("неверный номер максимального елемента");
            return null;
        }
    }
}
