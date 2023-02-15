package scenarios;

import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.native_page.BudgetPage;
import page_object.native_page.LoginPageObject;
import page_object.native_page.RegistrationPage;

public class nativeMobileTest extends BaseSetting {

    @Test(dataProvider = "nativeDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"native"},
            description = "Make sure that you are on the BudgetActivity page")
    public void RegistrationTest(User user, String budgetActivity) {
        LoginPageObject nativePageObject = (LoginPageObject) getPo().getPageObject();
        RegistrationPage registrationPage = nativePageObject.openRegistrationPage();
        registrationPage.registerNewUser(user, getDriver());
        BudgetPage budgetPage = nativePageObject.loginUser(user);
        budgetPage.waitForBudgetPageIsLoaded();
        Assert.assertEquals(budgetPage.getBudgetPageName(), budgetActivity);
    }
}