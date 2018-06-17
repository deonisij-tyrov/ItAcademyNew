package lection18ThreadsSynchronization;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Buyer implements Runnable {
    final static Logger logger = Logger.getLogger(Buyer.class.getSimpleName());
    private Map<Good, Integer> goods;
    private Shop shop;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        logger.info("покупатель зашел в магазин");
        goods = new HashMap<>();
        int countGoods = (int) (Math.random() * 5);
        if (countGoods == 0) {
            logger.info("покупатель ничего не выбрал и ушел");
        } else {
            for (int i = 0; i < countGoods; i++) {
                Integer goodNumber = (int) Math.random() * 12;
                int value = (int) Math.random() * 3;
                goods.put(shop.getGoods().get(goodNumber), value);
                logger.info(String.format("покупатель %s купил %d товаров %s",
                        Thread.currentThread().getName(), value, shop.getGoods().get(goodNumber).getName()));
            }

        }
    }
}
