package lection02;

import java.util.Scanner;

/*  Запросить у пользователя 2 слова. Если они одинаковы - вывести "Отлично! Слова одинаковы".
    Если они отличаются лишь регистром - "Хорошо. Почти одинаковы"
    Если они отличаются, но одной длины - "Ну, хотя бы они одной длины"
    Использовать методы класса String: equals(String string), equalsIgnoreCase(String string), length()*/
public class Task1 {
    public static void run() {
        System.out.println("Задача 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 слова:");
        String word1 = scanner.next();
        String word2 = scanner.next();

        if (word1.equals(word2)) {
            System.out.println("Отлично! Слова одинаковы");
            return;
        }
        if (word1.equalsIgnoreCase(word2)) {
            System.out.println("Хорошо. Почти одинаковы");
            return;
        }
        if (word1.length() == word2.length()) {
            System.out.println("Ну, хотя бы они одной длины");
            return;
        }
        System.out.println("Слова абсолютно разные");
    }
}
