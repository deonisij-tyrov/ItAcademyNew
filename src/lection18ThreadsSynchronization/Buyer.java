package lection18ThreadsSynchronization;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

@Data
public class Buyer implements Runnable {
    private final Semaphore semaphore;
    Receipt receipt;
    private Map<Good, Integer> goods;
    private Shop shop;

    public Buyer(Shop shop, Semaphore semaphore) {
        this.shop = shop;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Shop.logger.info(String.format("покупатель %s зашел в магазин", Thread.currentThread().getName()));
        goods = new HashMap<>();
        putGoods();
        if (goods.size() == 0) {
            return;
        }
        takeTurns();
    }

    private void putGoods() {
        int countGoods = (int) (Math.random() * 5);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Shop.logger.error(e.getMessage());
        }
        if (countGoods == 0) {
            Shop.logger.info(String.format("покупатель %s ничего не выбрал и ушел", Thread.currentThread().getName()));
        } else {
            for (int i = 0; i < countGoods; i++) {
                Integer goodId = (int) (Math.random() * 12) + 1;                /*значение по id товара*/
                int value = (int) (Math.random() * 3) + 1;                      /*количество*/
                Good good = shop.getGood(goodId);
                if (good != null) {
                    goods.put(good, value);
                    Shop.logger.info(String.format("покупатель %s взял %d товаров %s",
                            Thread.currentThread().getName(), value, good.getName()));
                } else {
                    Shop.logger.info(String.format("уже нет жедаемого товара для покупателя %s (((", Thread.currentThread().getName()));
                }
            }
        }
    }

    private void takeTurns() {
        Cashbox cashbox = shop.takeQueue();
        try {
            if (cashbox == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            Shop.logger.error(e.getMessage());
        }
        Shop.logger.info(String.format("покупатель %s занял кассу %d", Thread.currentThread().getName(), cashbox.getCasseNo()));
        double sumCost = cashbox.makeSum(goods);
        receipt = cashbox.payOff(goods, Math.ceil(sumCost));
        shop.logger.info(String.format("чек покупателя:\n%s %s", Thread.currentThread().getName(), receipt.toString()));
        shop.leaveQueue(cashbox);
    }
}
