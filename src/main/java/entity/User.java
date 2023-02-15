package entity;

import java.util.Locale;
import java.util.ResourceBundle;

public class User {

    private final String email;
    private final String userName;
    private final String password;

    public User() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("nativeTest", locale);
        this.userName = rb.getString("username");
        this.email = rb.getString("email");
        this.password = rb.getString("password");
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
