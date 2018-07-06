package lection23DAO.model;

import lombok.Data;

@Data
public class Cell {
    private long id;
    private String name;
    private int sector;
    private int power;
    private long bsNumber;
    private int band;

    public Cell(String name, int sector, int power, long bsNumber, int band) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.power = power;
        this.bsNumber = bsNumber;
        this.band = band;
    }

    public Cell(long id, String name, int sector, int power, long bsNumber, int band) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.power = power;
        this.bsNumber = bsNumber;
        this.band = band;
    }

    public Cell() {
    }
}
