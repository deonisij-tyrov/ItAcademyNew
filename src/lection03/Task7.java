package lection03;

/*    Написать программу, эмулирующую выдачу случайной карты из колоды в 52 карты.
      Вывести результат в формате "Карта of Масть". Например, "AceofSpades".
      Валет - Jack, Дама - Queen, Король - King, Туз - Ace, Червы - Hearts, Пики - Spades, Трефы - Clubs, Бубны - Diamonds
*/
public class Task7 {
    static void run() {
        System.out.println("Задача 7");
        int cardNumber = (int) (Math.random() * 13);
        int suitNumber = (int) (Math.random() * 4);
        String[][] cards = cards();
        System.out.print(cards[suitNumber][cardNumber]);
    }

    static String[][] cards() {
        String[] suit = new String[4];
        suit[0] = "Hearts";
        suit[1] = "Spades";
        suit[2] = "Clubs";
        suit[3] = "Diamonds";

        String[] card = new String[13];
        card[0] = "2";
        card[1] = "3";
        card[2] = "4";
        card[3] = "5";
        card[4] = "6";
        card[5] = "7";
        card[6] = "8";
        card[7] = "9";
        card[8] = "10";
        card[9] = "Jack";
        card[10] = "Queen";
        card[11] = "King";
        card[12] = "Ace";

        String[][] cards = new String[4][13];
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < card.length; j++) {
                cards[i][j] = card[j] + " of " + suit[i];
            }
        }

        return cards;
    }


}
