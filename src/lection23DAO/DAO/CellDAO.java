package lection23DAO.DAO;

import lection23DAO.model.BaseStation;
import lection23DAO.model.Cell;

import java.sql.SQLException;
import java.util.List;

public interface CellDAO extends DAO<Cell, Long> {
    List<Cell> readCellByBaseStation(BaseStation baseStation) throws SQLException;

    void addNewBaseStationCells(BaseStation baseStation) throws SQLException;

    List<Cell> readAll() throws SQLException;
}
