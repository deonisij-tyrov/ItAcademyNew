package lection23DAO.DAO;

import lection23DAO.BaseStation;
import lection23DAO.Cell;

import java.sql.SQLException;
import java.util.List;

public interface CellDAO extends DAO<Cell, Long> {
    List<Cell> BaseStation(BaseStation baseStation) throws SQLException;
}
