package properties;

import entity.User;

import java.util.Locale;
import java.util.ResourceBundle;

public class UserProperty {

    private final String username;
    private final String email;
    private final String password;

    public UserProperty() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("nativeTest", locale);
        this.username = rb.getString("username");
        this.email = rb.getString("email");
        this.password = rb.getString("password");
    }

    public User getUser() {
        return new User();
    }
}