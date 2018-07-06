package lection23DAO.model;

import lombok.Data;

import java.util.List;

@Data
public class BaseStation {
    private long id;
    private String name;
    private List<Cell> cells;

    public BaseStation(long id, String name, long bsNumber, List<Cell> cells) {
        this.id = id;
        this.name = name;
        this.cells = cells;
    }
}
