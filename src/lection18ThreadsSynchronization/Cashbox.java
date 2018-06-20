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
    private boolean isFree;
    private int casseNo;
    private Buyer buyer;

    public Cashbox(int casseNo) {
        this.isFree = true;
        this.casseNo = casseNo;
    }

    public Receipt makeReceipt(Map<Good, Integer> goods) {
        List<Item> items = new ArrayList<>();
        int i = 0;
        int sum = 0;
        for (Map.Entry<Good, Integer> m : goods.entrySet()) {
            ++i;
            sum += m.getKey().getPrice() - m.getKey().getDiscount();
            items.add(new Item(i, m.getKey().getName(), m.getValue(), m.getKey().getPrice(), m.getKey().getDiscount(),
                    m.getKey().getPrice() - m.getKey().getDiscount()));
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Receipt(++idReceipt, new SimpleDateFormat("dd/M/yyyy").format(new Date()), casseNo, items, sum);
    }

}
