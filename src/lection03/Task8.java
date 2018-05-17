package lection03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Написать программу, перемешивающую и печатающую список карт в колоде.
 * Воспользоваться результатом предыдущей задачи.
 */
public class Task8 {
    public static void run() {
        System.out.println("Задача 8");
        String[][] cards = Task7.cards();
        print(cards);
        System.out.println("");
//        cards = mixCardsVar1(cards);
//        print(cards);

        cards = mixCardsVar2(cards);
        print(cards);

    }

    static String[][] mixCardsVar1(String[][] cards) {
        for (int i = 0; i < 3; i++) {
            int cardNumber1 = (int) (Math.random() * 13);
            int suitNumber1 = (int) (Math.random() * 4);
            int cardNumber2 = (int) (Math.random() * 13);
            int suitNumber2 = (int) (Math.random() * 4);

            String tmp = cards[suitNumber1][cardNumber1];
            cards[suitNumber1][cardNumber1] = cards[suitNumber2][cardNumber2];
            cards[suitNumber2][cardNumber2] = tmp;
        }
        return cards;
    }

    static private String[][] mixCardsVar2(String[][] cards) {
        for (int i = 0; i < cards.length; i++) {
            List<String> list = Arrays.asList(cards[i]);
            Collections.shuffle(list);
            cards[i] = list.toArray(cards[i]);
        }
        List<String[]> list = Arrays.asList(cards);
        Collections.shuffle(list);
        cards = list.toArray(cards);
        return cards;
    }

    static private void print(String[][] cards) {
        for (String[] strings : cards) {
            for (String string : strings) {
                System.out.print(string + "; ");
            }
            System.out.println("");
        }
    }
}
