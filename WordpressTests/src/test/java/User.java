import java.io.*;

public class User {
    private static final String FILE_PATH = "login_password.txt";
    private String role;
    private String user_login;
    private String user_pass;

    public User(String role, String user_login, String user_pass) {
        this.role = role;
        this.user_login = user_login;
        this.user_pass = user_pass;
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
}
