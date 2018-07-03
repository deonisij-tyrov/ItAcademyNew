package lection23DAO.DAO;

import java.sql.SQLException;

public interface DAO<Entity, Key> {
    Entity create(Entity entity) throws SQLException;
    Entity read(Key key) throws SQLException;
    void update(Entity entity) throws SQLException;
    int delete(Key key) throws SQLException;
}