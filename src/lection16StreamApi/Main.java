package lection16StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(sumOfDivisionBy5(Arrays.asList(10, 15, 11, 20, 4, 3, 75, 25)));
        System.out.println(stringsCount(Arrays.asList("asdasd","asdasdasda", "hi", "hi")));
    }

    /*Дан список целых чисел. Найти среднее всех нечётных чисел,
    делящихся на 5.*/
    public static double sumOfDivisionBy5(List<Integer> list) {
        return list
                .stream()
                .filter((element) -> (element % 2) != 0 && (element % 5) == 0)
                .mapToInt(element -> element)
                .average()
                .getAsDouble();
    }

    /*Дан список строк. Найти количество уникальных строк длиной более 8 символов.*/
    public static long stringsCount (List<String> list) {
        return list
                .stream()
                .filter(element -> element.length() < 9)
                .distinct()                                                                       //collect(Collectors.toSet())
                .count();                                                                         //size() - int
    }

    /*Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.*/
    public static int sumValueByKey (Map<String, Integer> map) {

    }
}
