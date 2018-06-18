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
    private Map<Integer, Good> goods;

    public Shop() {
        goods = new HashMap();
        goods.put(0, new Good(1, "пиво", 2.2, 0.1));
        goods.put(1, new Good(2, "водка", 5, 0.2));
        goods.put(2, new Good(3, "чипсы", 1.2, 0.3));
        goods.put(3, new Good(4, "хлеб", 0.7, 0.5));
        goods.put(4, new Good(5, "молоко", 1.5, 0.89));
        goods.put(5, new Good(6, "селедка", 2.5, 0.4));
        goods.put(6, new Good(7, "кефир", 1.7, 0.5));
        goods.put(7, new Good(8, "батон", 0.5, 0.3));
        goods.put(8, new Good(9, "гречка", 3.5, 0.0));
        goods.put(9, new Good(10, "колбаски", 5.2, 0.3));
        goods.put(10, new Good(11, "йогурт", 2.45, 0.1));
        goods.put(11, new Good(12, "булочка из печки", 0.4, 0.1));
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
