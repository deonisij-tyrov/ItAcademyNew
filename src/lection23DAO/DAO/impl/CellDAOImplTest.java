package lection23DAO.DAO.impl;

import lection23DAO.model.Cell;
import lection23DAO.DAO.CellDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class CellDAOImplTest {
    private CellDAO cellDAO = CellDAOImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        int countBeforeSave = cellDAO.readAll().size();
        Cell cell = cellDAO.create(new Cell("005-S2", 2, 0, 000, 3));
        int countAfterSave = cellDAO.readAll().size();
        Assert.assertNotSame(countAfterSave, countBeforeSave);
        Cell readCell = cellDAO.read(cell.getId());
        Assert.assertEquals(cell, readCell);

        cell.setPower(0);
        readCell = cellDAO.read(cell.getId());
        Assert.assertEquals(cell, readCell);

        cellDAO.delete(cell.getId());
        int countAfterDelete = cellDAO.readAll().size();
        Assert.assertEquals(countBeforeSave, countAfterDelete);
    }

}
