package lection23DAO;

import lombok.Data;

@Data
public class BaseStation {
    private long id;
    private String name;
    private long bsNumber;
    private Cell[] cells;
    public BaseStation(long id, String name, long bsNumber, Cell[] cells) {
        this.id = id;
        this.name = name;
        this.bsNumber = bsNumber;
        this.cells = cells;
    }
}
