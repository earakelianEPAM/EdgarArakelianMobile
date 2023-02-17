package entity;

import java.util.Locale;
import java.util.ResourceBundle;

public class User {

    private final String email;
    private final String userName;
    private final String password;

    public User() {
        this.userName = System.getenv("userName");
        this.email = System.getenv("email");
        this.password = System.getenv("password");
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
