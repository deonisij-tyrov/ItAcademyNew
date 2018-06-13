package lection15StreamApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        System.out.println("задача 1 \n" + averageDivisibleByOddAndFive(Arrays.asList(15, 25, 10, 11, 88, 60, 20, 35, 45)));

        System.out.println("задача 2 \n" + countOfUniqueLinesLengthLesEight(Arrays.asList("pass", "apple", "qwertyui111", "as", "as", "as")));

        Map<String, Integer> map = new HashMap<>();
        map.put("as", 1);
        map.put("131", 3);
        map.put("as131313131313", 5);
        map.put("132", 1);
        map.put("111111111111131", 3);
        map.put("as131313131313", 5);
        System.out.println("задача 3 \n" + sumOfValue(map));

        System.out.println("задача 4 \n" + concatenation(Arrays.asList(1, 2, 1, 1, 8, 0, 2, 3, 4)));

    }

    /*Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.*/
    public static double averageDivisibleByOddAndFive(List<Integer> list) {
        return list
                .stream()
                .filter(integer -> integer % 5 == 0)
                .filter(integer -> integer % 2 != 0)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    /*Дан список строк. Найти количество уникальных строк длиной более 8 символов. */
    public static long countOfUniqueLinesLengthLesEight(List<String> list) {
        return list
                .stream()
                .filter(s -> s.length() <= 8)
                .distinct()
                .count();
//        return  list
//                .stream()
//                .filter(s -> s.length() <= 8)
//                .collect(Collectors.toSet())
//                .size();
    }

    /*Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов. */
    public static long sumOfValue(Map<String, Integer> map) {
        return map
                .entrySet()
                .stream()
                .filter(m -> m.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    /*Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
    Пример: список {5, 2, 4, 2, 1}
    Результирующая строка: "52421" */
    public static String concatenation(List<Integer> list) {
//        return list
//                .stream()
//                .collect(
//                        Collector.of(
//                                StringBuilder::new, // метод_инициализации_аккумулятора
//                                (sb, s) -> sb.append(s), // метод_обработки_каждого_элемента,
//                                (b1, b2) -> b1.append(b2), // метод_соединения_двух_аккумуляторов
//                                StringBuilder::toString // метод_последней_обработки_аккумулятора
//                        )
//                );

//        list
//                .stream()
//                .forEach(element -> System.out.print(element));

        return list
                .stream()
                .map(element -> element.toString())
                .reduce("",(base, element) -> base + element);
    }
}
