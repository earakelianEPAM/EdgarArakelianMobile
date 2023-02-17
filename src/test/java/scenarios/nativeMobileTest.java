package scenarios;

import entity.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object.native_page.BudgetPage;
import page_object.native_page.LoginPageObject;
import page_object.native_page.RegistrationPage;
import page_object.util.BaseSettings;

public class nativeMobileTest extends BaseSettings {
    SoftAssert softAssert = new SoftAssert();

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