package lection18ThreadsSynchronization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Receipt {
    private int id;
    private String date;
    private int casseNo;
    private List<Item> items;
    private double totalSum;
//    private double change;


}
