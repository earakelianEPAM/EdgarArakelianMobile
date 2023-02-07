package homework2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.NativeTest;

public class NativeMobileTests extends NativeTest {

    @Parameters({"email", "username", "password"})
    @Test(description = "Registering as new user and opening Budget activity page")
    public void registerAndMainPageTest(String email, String username, String password) {
        getLoginPo().openRegistrationPage();
        getRegistrationPo().registerUser(email, username, password);
        getLoginPo().signIn(email, password);
        getBudgetActivityPo().assertExpensesListExists();
    }
}
