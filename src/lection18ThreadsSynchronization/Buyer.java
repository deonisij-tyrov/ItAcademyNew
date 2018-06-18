package lection18ThreadsSynchronization;

import lombok.Data;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@Data
public class Buyer implements Runnable {
    final static Logger logger = Logger.getLogger(Buyer.class.getSimpleName());
    Receipt receipt;
    private Map<Good, Integer> goods;
    private Shop shop;
    private Cashbox cashbox;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        logger.info(String.format("покупатель %s зашел в магазин", Thread.currentThread().getName()));
        goods = new HashMap<>();
        putGoods();
        paysCashier();
    }

    private void putGoods() {
        int countGoods = (int) (Math.random() * 5);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        if (countGoods == 0) {
            logger.info(String.format("покупатель %s ничего не выбрал и ушел", Thread.currentThread().getName()));
        } else {
            for (int i = 0; i < countGoods; i++) {
                Integer goodNumber = (int) (Math.random() * 12);
                int value = (int) (Math.random() * 3) + 1;
                goods.put(shop.getGoods().get(goodNumber), value);
                logger.info(String.format("покупатель %s взял %d товаров %s",
                        Thread.currentThread().getName(), value, shop.getGoods().get(goodNumber).getName()));
            }
        }
    }

    private void paysCashier() {
        synchronized (shop.getCASHBOXES()) {
            try {
                shop.getSEMAPHORE().acquire();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            for (int i = 0; i < shop.getCASHBOXES().length; i++) {
                if (shop.getCASHBOXES()[i].isFree()) {
                    cashbox = shop.getCASHBOXES()[i];
                    cashbox.setFree(false);
                    break;
                }
            }
        }
        logger.info(String.format("покупатель %s занял очередь в кассе %d", Thread.currentThread().getName(), cashbox.getCasseNo()));
        receipt = cashbox.makeReceipt(goods);
        logger.info("чек покупателя:" + Thread.currentThread().getName() + receipt.toString());
        cashbox.setFree(true);
        shop.getSEMAPHORE().release();
    }
}
