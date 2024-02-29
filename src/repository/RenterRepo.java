package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RenterRepo {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String password = "admin";
    private final String username = "postgres";

    public Connection ConnectToDb(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
