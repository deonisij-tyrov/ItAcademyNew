package lection18ThreadsSynchronization;

import java.util.HashMap;
import java.util.Map;

public class Buyer implements Runnable {
    private Map<Good, Integer> goods;
    private Shop shop;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        goods = new HashMap<>();
        int countGoods = (int) (Math.random() * 5);
        if (countGoods == 0) {
            System.out.println("покупатель ничего не выбрал");
        } else {
            for (int i = 0; i < countGoods; i++) {
                Integer good = (int) Math.random() * 12;
                int number = (int) Math.random() * 3;
                goods.put(shop.getGoods().get(good), number);
            }
        }
    }
}
