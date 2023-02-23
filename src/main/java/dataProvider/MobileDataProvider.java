package dataProvider;

import entity.User;
import org.testng.annotations.DataProvider;

import java.util.ResourceBundle;

public class MobileDataProvider {

    private final User user;
    private final ResourceBundle rbNative;
    private final ResourceBundle rbWeb;
    private static final String nativeTestProperties = "nativeTest";
    private static final String webTestProperties = "webTest";
    private static final String googleUrlProperty = "googleURL";
    private static final String searchProperty = "search";
    private static final String budgetActivityProperty = "budgetActivity";

    public MobileDataProvider() {
        user = new User();
        rbNative = ResourceBundle.getBundle(nativeTestProperties);
        rbWeb = ResourceBundle.getBundle(webTestProperties);
    }

    @DataProvider
    public Object[][] webDataProvider() {
        return new Object[][] {
                {rbWeb.getString(googleUrlProperty), rbWeb.getString(searchProperty)}
        };
    }

    @DataProvider
    public Object[][] nativeDataProvider() {
        return new Object[][] {
                {user, rbNative.getString(budgetActivityProperty)}
        };
    }
}
