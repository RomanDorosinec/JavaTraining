package by.dorosinec.traning.phonebook.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class working whit database
 */
public class DBWorker {

    private Integer affected_rows = 0;

    // The value of the auto-increment primary key obtained after the addition of the new record.
    private Integer last_insert_id = 0;

    // A pointer to a class instance.
    private static DBWorker instance = null;

    /**
     * Method for the instance (Singleton implemented).
     */
    public static DBWorker getInstance() {
        if (instance == null) {
            instance = new DBWorker();
        }

        return instance;
    }

    // To class instance can not be obtained directly.
    private DBWorker() {

    }

    /**
     * Method queries the database to retrieve data
     *
     * @param query request that created
     * @return
     */
    public ResultSet getDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println("null on getDBData()!");
        return null;

    }

    /**
     * Method executes queries to the database to modify data
     *
     * @param query request that created
     * @return
     */
    public Integer changeDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            // Получаем last_insert_id() для операции вставки.
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                this.last_insert_id = rs.getInt(1);
            }

            return this.affected_rows;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println("null on changeDBData()!");
        return null;
    }

    public Integer getAffectedRowsCount() {
        return this.affected_rows;
    }

    public Integer getLastInsertId() {
        return this.last_insert_id;
    }
}

