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

    public static boolean isUnique(Map<String, String> map) {
        Set<String> setKey = map.keySet();
        Set<String> setvalue = new HashSet<>();
        setvalue.addAll(map.values());
        return setKey.size() == setvalue.size();
    }

    public static String summaryPolynomial(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {

        for (Map.Entry<Integer, Integer> m1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> m2 : map2.entrySet()) {
                if (m1.getKey().equals(m2.getKey())) {
                    map1.put(m1.getKey(), m1.getValue() + m2.getValue());
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> m : map1.entrySet()) {
            builder.append(m.getKey() + "^x" + m.getValue() + "+");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.reverse();
        return builder.toString();
    }
}
