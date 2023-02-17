package scenarios;

import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativeTest.BudgetPage;
import pageObjects.nativeTest.LoginPageObject;
import pageObjects.nativeTest.RegistrationPage;
import properties.MobileDataProvider;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

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
