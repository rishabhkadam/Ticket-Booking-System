package ConnectJDBC;

import java.sql.*;

public class ConnectJDBC {

    public static Connection connection;

    public ConnectJDBC() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Booking_db", "root", "rishabh20");

            // Statement statement;
            // statement = connection.createStatement();
            // statement.executeQuery("show databases;");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void QueryUpdate(String query) {
        try {
            Statement statement;
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void QueryExecute(String query) {
        try {
            Statement statement;
            statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
