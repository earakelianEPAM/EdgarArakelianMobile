package scenarios;

import dataprovider.MobileDataProvider;
import entity.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.nativepage.BudgetPage;
import pages.nativepage.LoginPageObject;
import pages.nativepage.RegistrationPage;
import setup.BaseSettings;

public class nativeMobileTest extends BaseSettings {

    private final String email = System.getenv("email");
    private final String userName = System.getenv("userName");
    private final String password = System.getenv("password");

    @Test(dataProvider = "nativeDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"native"},
            description = "Make sure that you are on the BudgetActivity page")
    public void RegistrationTest(User user, String budgetActivity) {
        LoginPageObject loginPageObject = new LoginPageObject(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        loginPageObject.pushRegisterAccountButton();
        waitDriver().until(ExpectedConditions.visibilityOf(RegistrationPage.registrationHeader));
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(userName);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.pushRegisterButton();

        loginPageObject.enterEmail(email);
        loginPageObject.enterPassword(password);
        loginPageObject.pushSignInButton();

        BudgetPage budgetPage = new BudgetPage(appiumDriver);
        budgetPage.waitForBudgetPageIsLoaded();
        Assert.assertTrue(BudgetPage.budgetActionBarText.isDisplayed());
    }
}