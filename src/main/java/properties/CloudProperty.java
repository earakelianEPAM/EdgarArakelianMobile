package properties;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class CloudProperty {

    public static String API_KEY;
    public static final String EMAIL;
    public static final String APPIUM_HUB;

    static {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("cloudTest", locale);
        API_KEY = rb.getString("apiKey");
        EMAIL = rb.getString("email");
        APPIUM_HUB = rb.getString("appiumHub");

        try {
            API_KEY = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}