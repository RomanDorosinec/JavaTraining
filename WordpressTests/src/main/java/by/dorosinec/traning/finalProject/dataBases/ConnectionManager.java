package by.dorosinec.traning.finalProject.dataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class ConnectionManager {
    private static final String DB_HOST = "jdbc:mysql://localhost:8889/wordpress";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "root";

    private Connection connection;

    /**
     * Creates a Connection to a database with specified Connection properties (url, username, password).
     */
    public Connection openConnection() {
        try {
            connection = DriverManager.getConnection(DB_HOST, DB_USER_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("MySQL JDBC Driver not found.");
        }
        return connection;
    }

    /**
     * Drops given database Connection.
     *
     * @param connection Connection to drop (close)
     */
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
