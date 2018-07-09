import dataBaseManager.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/db")
public class DbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try (Connection connection = ConnectionManager.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count FROM visits WHERE id = 0;");
            resultSet.next();
            Integer visits = resultSet.getInt(1);
            visits++;

            writer.print("\ncount visits - " + visits.toString());
            statement.executeUpdate("UPDATE visits SET count = " + visits + " WHERE id =0;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
