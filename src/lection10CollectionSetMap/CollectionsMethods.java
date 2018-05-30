package lection10CollectionSetMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsMethods {
    public static int countUnique(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        return set.size();
    }

//    public static boolean isUnique(Map<String, String>) {
//        return null;
//    }
}
