package lection10CollectionSetMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsMethods {
    public static int countUnique(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        return set.size();
    }

    public static boolean isUnique(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return new HashSet<String>(map.values()).size() == map.size();
    }

    public static String summaryPolynomial(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        Map<Integer, Integer> mapSummary = map1;
        for (Map.Entry<Integer, Integer> m1 : mapSummary.entrySet()) {
            for (Map.Entry<Integer, Integer> m2 : map2.entrySet()) {
                if (m1.getKey().equals(m2.getKey())) {
                    mapSummary.put(m1.getKey(), m1.getValue() + m2.getValue());
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> m : mapSummary.entrySet()) {
            builder.append(m.getKey() + "^x" + m.getValue() + "+");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.reverse();
        return builder.toString();
    }
}
