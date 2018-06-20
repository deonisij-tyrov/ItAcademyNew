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
    double sum;
    private boolean free;
    private int casseNo;
    private Buyer buyer;

    public Cashbox(int casseNo) {
        this.free = true;
        this.casseNo = casseNo;
    }

    public Receipt payOff(Map<Good, Integer> goods, double money) {
        List<Item> items = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Good, Integer> m : goods.entrySet()) {
            ++i;
            items.add(new Item(i, m.getKey().getName(), m.getValue(), m.getKey().getPrice(), m.getKey().getDiscount(),
                    m.getKey().getPrice() - m.getKey().getDiscount()));
            try {
                Thread.currentThread().sleep(2000);
                System.out.println(Thread.currentThread().getName() + " sleep 100");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Receipt(++idReceipt, new SimpleDateFormat("dd.M.yyyy").format(new Date()), casseNo, items, sum, money - sum);
    }

    public double makeSum(Map<Good, Integer> goods) {
        return this.sum = goods.entrySet()
                .stream()
                .mapToDouble(good -> good.getKey().getPrice() * good.getKey().getDiscount() * good.getValue())
                .count();
//        return this.sum = round(sum);
    }

//    private double round(double number) {
//        int scale = new Double(sum).toString().indexOf('.') + 2;
//        int pow = 10;
//        for (int i = 1; i < scale; i++) {
//            pow *= 10;
//        }
//        double tmp = number * pow;
//        return (double) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
//    }
}
