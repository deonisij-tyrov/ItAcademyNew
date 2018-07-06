package lection22JDBC;

import lection23DAO.dataBaseManager.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassForDbConnection {
    private static final String INSERT = "INSERT INTO `books` VALUES (?,?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM books;";
    private static final String DELETE = "DELETE FROM books WHERE id_book = ?;";
    private static final String UPDATE_NAME = "UPDATE books SET name = ? WHERE id_book = ?;";
    private static PreparedStatement preparedStatement;
    private static Connection connection;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        initConnection();
        try {
            if (!connection.isClosed()) {
                System.out.println("содинение установлено");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        insert(13, "new_book", 5000, "Novel");
        selectAll();
        updateName(13,"change_name");
        System.out.println("after update");
        selectAll();
        delete(13);
        System.out.println("after delete");
        selectAll();
    }

    private static void initConnection() {
        connection = ConnectionManager.getConnection();
    }

    private static void insert(int id, String name, int pages, String genre) {
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, pages);
            preparedStatement.setString(4, genre);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAll() {
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d %s %d %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateName(int id, String name) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_NAME);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
