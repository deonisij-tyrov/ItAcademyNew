package lection18ThreadsSynchronization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private int number;
    private String goodName;
    private int quantity;
    private double cost;
    private double discount;
    private double discountAmount;
}
