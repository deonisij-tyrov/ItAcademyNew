package lection18ThreadsSynchronization;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Shop {
    final static Logger logger = Logger.getLogger(Buyer.class.getSimpleName());
    private static final int MAX_QUANTITY_OF_GOODS = 10;
    private static Semaphore semaphore = new Semaphore(3, true);
    private final Cashbox[] CASHBOXES;
    private Map<Good, Integer> goods;

    public Shop() {
        goods = new HashMap();
        goods.put(new Good(1, "пиво", 2.2, 0.1), randomGoodCount());
        goods.put(new Good(2, "водка", 5, 0.2), randomGoodCount());
        goods.put(new Good(3, "чипсы", 1.2, 0.3), randomGoodCount());
        goods.put(new Good(4, "хлеб", 0.7, 0.18), randomGoodCount());
        goods.put(new Good(5, "молоко", 1.5, 0.89), randomGoodCount());
        goods.put(new Good(6, "селедка", 2.5, 0.4), randomGoodCount());
        goods.put(new Good(7, "кефир", 1.7, 0.5), randomGoodCount());
        goods.put(new Good(8, "батон", 0.5, 0.3), randomGoodCount());
        goods.put(new Good(9, "гречка", 3.5, 0.1), randomGoodCount());
        goods.put(new Good(10, "колбаски", 5.2, 0.3), randomGoodCount());
        goods.put(new Good(11, "йогурт", 2.45, 0.1), randomGoodCount());
        goods.put(new Good(12, "булочка из печки", 0.4, 0.1), randomGoodCount());
        CASHBOXES = new Cashbox[3];
        for (int i = 0; i < CASHBOXES.length; i++) {
            CASHBOXES[i] = new Cashbox(i);
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        for (int i = 0; i < 10; i++) {
            new Thread(new Buyer(shop, semaphore), "Покупатель " + i).start();
        }
    }

    private int randomGoodCount() {
        return (int) (Math.random() * MAX_QUANTITY_OF_GOODS);
    }

    public synchronized Good getGood(int goodId) {
        Good good = null;
        try {
            good = goods.entrySet()
                    .stream()
                    .filter(pair -> pair.getKey().getId() == goodId)
                    .findFirst()
                    .get()
                    .getKey();
        } catch (NoSuchElementException e) {
            logger.error(e.toString());
        }
        if (good != null) {
            int countGood = goods.get(good);
            if (countGood > 0) {
                goods.put(good, --countGood);
                return good;
            }
        }
        return null;
    }

    public Cashbox takeQueue() {
        try {
            logger.warn("ждем доступа " + Thread.currentThread().getName());
            semaphore.acquire();
            logger.warn(semaphore.toString() + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return getCashbox();
    }

    private synchronized Cashbox getCashbox() {
        for (int i = 0; i < CASHBOXES.length; i++) {
            if (CASHBOXES[i].isFree()) {
                CASHBOXES[i].setFree(false);
                return CASHBOXES[i];
            }
        }
        return null;
    }

    public void leaveQueue(Cashbox cashbox) {
        for(int i = 0; i < CASHBOXES.length; i++) {
            if(CASHBOXES[i] == cashbox) {
                cashbox.setFree(true);
                logger.warn("освобождаем " + Thread.currentThread().getName());
                semaphore.release();
                logger.warn(semaphore.toString() + Thread.currentThread().getName());
            }
        }
    }
}
