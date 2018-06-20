package lection18ThreadsSynchronization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

@Data
@AllArgsConstructor
public class Shop {
    private final Cashbox[] CASHBOXES;
    private final Semaphore SEMAPHORE = new Semaphore(3, true);
    private Map<Good, Integer> goods;

    public Shop() {
        goods = new HashMap();
        goods.put(new Good(1, "пиво", 2.2, 0.1), 0);
        goods.put(new Good(2, "водка", 5, 0.2), 0);
        goods.put(new Good(3, "чипсы", 1.2, 0.3), 0);
        goods.put(new Good(4, "хлеб", 0.7, 0.5), 0);
        goods.put(new Good(5, "молоко", 1.5, 0.89), 0);
        goods.put(new Good(6, "селедка", 2.5, 0.4), 0);
        goods.put(new Good(7, "кефир", 1.7, 0.5), 0);
        goods.put(new Good(8, "батон", 0.5, 0.3), 0);
        goods.put(new Good(9, "гречка", 3.5, 0.0), 0);
        goods.put(new Good(10, "колбаски", 5.2, 0.3), 0);
        goods.put(new Good(11, "йогурт", 2.45, 0.1), 0);
        goods.put(new Good(12, "булочка из печки", 0.4, 0.1), 0);
        for (Map.Entry<Good, Integer> m : goods.entrySet()) {
            int valueGood = (int) (Math.random() * 50);
            goods.put(m.getKey(), valueGood);
        }
        CASHBOXES = new Cashbox[3];
        for (int i = 0; i < CASHBOXES.length; i++) {
            CASHBOXES[i] = new Cashbox(i);
        }
    }


    public static void main(String[] args) {
        Shop shop = new Shop();
        for (int i = 0; i < 7; i++) {
            new Thread(new Buyer(shop), "buyer " + i).start();
        }
    }
}
