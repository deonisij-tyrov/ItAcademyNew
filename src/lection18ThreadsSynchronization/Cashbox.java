package lection18ThreadsSynchronization;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Cashbox {
    private static int idReceipt;
    private double totalSum;
    private boolean free;
    private int casseNo;
    private Buyer buyer;

    public Cashbox(int casseNo) {
        this.free = true;
        this.casseNo = casseNo;
    }

    public Receipt payOff(Map<Good, Integer> goods, double moneyFromBuyer) {
        List<Item> items = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Good, Integer> good : goods.entrySet()) {
            ++i;
            double discountAmount = round((good.getKey().getPrice() - (good.getKey().getPrice() * good.getKey().getDiscount())) * good.getValue());
            items.add(new Item(i, good.getKey().getName(), good.getValue(), good.getKey().getPrice(), good.getKey().getDiscount(), discountAmount));
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Receipt(++idReceipt, new SimpleDateFormat("dd.M.yyyy HH:mm:ss").format(new Date()), casseNo, items, totalSum, round(moneyFromBuyer - totalSum), moneyFromBuyer);
    }

    public double makeSum(Map<Good, Integer> goods) {
        this.totalSum = goods.entrySet()
                .stream()
                .mapToDouble(good -> ((good.getKey().getPrice() - (good.getKey().getPrice() * good.getKey().getDiscount())) * good.getValue()))
                .sum();
        return this.totalSum = round(totalSum);
    }

    private double round(double number) {
        int scale = 2;
        int pow = 10;
        for (int i = 1; i < scale; i++) {
            pow *= 10;
        }
        double tmp = number * pow;
        return (double) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }
}
