package lection18ThreadsSynchronization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class Receipt {
    private int id;
    private String date;
    private int casseNo;
    private List<Item> items;
    private double totalSum;
    private double change;

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", casseNo=" + casseNo +
                ", items=" + items +
                ", totalSum=" + totalSum +
                ", change=" + change +
                "}\n";
    }
}
