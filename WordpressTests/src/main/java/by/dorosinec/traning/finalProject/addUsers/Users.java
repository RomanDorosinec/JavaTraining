package by.dorosinec.traning.finalProject.addUsers;

/**
 * Class of Users
 * All information about one user
 */
public class Users {
    private String role;
    private String user_login;
    private String user_pass;
    private String wp_capabilities;
    private String wp_user_level;

    public Users(String role, String user_login, String user_pass,String wp_capabilities, String wp_user_level) {
        this.role = role;
        this.user_login = user_login;
        this.user_pass = user_pass;
        this.wp_capabilities = wp_capabilities;
        this.wp_user_level = wp_user_level;
    }

    public String getRole() {
        return role;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public String getWp_capabilities() {
        return wp_capabilities;
    }

    public String getWp_user_level() {
        return wp_user_level;
    }
}

