package lection10CollectionSetMap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(CollectionsMethods.countUnique(list));
    }
}
