package lection10CollectionSetMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        example3();
    }

    public static void example1 () {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(CollectionsMethods.countUnique(list));
    }
    public static void example2() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "two");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        System.out.println("example 2: " + CollectionsMethods.isUnique(map));
    }

    public static void example3() {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        map1.put(6, 4);
        map1.put(5, 3);
        map1.put(2, 6);
        map1.put(1, 1);

        map2.put(5, 4);
        map2.put(4, 3);
        map2.put(3, 10);
        map2.put(1, 1);

        System.out.println(CollectionsMethods.summaryPolynomial(map1, map2));
    }
}
