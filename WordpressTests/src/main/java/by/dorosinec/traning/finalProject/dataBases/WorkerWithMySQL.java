package by.dorosinec.traning.finalProject.dataBases;

import by.dorosinec.traning.finalProject.addUsers.Users;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class working with databases. Add necessary data which we used in tests
 */
public class WorkerWithMySQL {
    private static final String WP_USERMETA_CAPABILITIES = "INSERT INTO wp_usermeta(user_id, meta_key, meta_value) VALUES (?, 'wp_capabilities', ?)";
    private static final String WP_USERMETA_USER_LEVEL = "INSERT INTO wp_usermeta(user_id, meta_key, meta_value) VALUES (?, 'wp_user_level', ?)";
    private static final String WP_USERS_ADD_USER = "INSERT INTO wp_users(user_login, user_pass) VALUES (?, MD5(?))";

    private ConnectionManager connectionDB = new ConnectionManager();

    /**
     * Performance of all queries
     *
     * @param users object user with all information about him
     */
    public void addLineOfTables(ArrayList<Users> users) {
        int countUsers = 2;
        for (Users user : users) {
            addToUsers(user);
            addToUsermetaCapabilities(user, countUsers);
            addToUsermetaUserLevel(user, countUsers);
            countUsers++;
        }
    }

    /**
     * Make query of wp_usermeta table.
     * Query to add the user's role
     *
     * @param users      object user with all information about him
     * @param countUsers
     */
    public void addToUsermetaCapabilities(Users users, int countUsers) {
        Connection connection = connectionDB.openConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(WP_USERMETA_CAPABILITIES);
            preparedStatement.setInt(1, countUsers);
            preparedStatement.setString(2, users.getWp_capabilities());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
    }

    /**
     * Make query of wp_usermeta table.
     * Query to add the user's level(the necessary information for defining the role of)
     *
     * @param users      object user with all information about him
     * @param countUsers
     */
    public void addToUsermetaUserLevel(Users users, int countUsers) {
        Connection connection = connectionDB.openConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(WP_USERMETA_USER_LEVEL);
            preparedStatement.setInt(1, countUsers);
            preparedStatement.setString(2, users.getWp_user_level());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
    }

    /**
     * Make query of wp_users table.
     * Query to add the user on the site
     *
     * @param users object user with all information about him
     */
    public void addToUsers(Users users) {
        Connection connection = connectionDB.openConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(WP_USERS_ADD_USER);
            preparedStatement.setString(1, users.getUser_login());
            preparedStatement.setString(2, users.getUser_pass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionDB.closeConnection(connection);
        }
    }
}
