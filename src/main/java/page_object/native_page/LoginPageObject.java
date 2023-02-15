package page_object.native_page;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page_object.util.Util;

public class LoginPageObject extends Util {

    @AndroidFindBy(id = APPLIC_NAME_ID + "email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;

    @AndroidFindBy(id = APPLIC_NAME_ID + "register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    private WebElement registerBtn;

    @AndroidFindBy(id = APPLIC_NAME_ID + "login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement emailInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement passInput;

    public LoginPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationPage openRegistrationPage() {
        appiumDriver.hideKeyboard();
        registerBtn.click();
        return new RegistrationPage(appiumDriver);
    }

    public BudgetPage loginUser(User user) {
        emailInput.sendKeys(user.getEmail());
        passInput.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        signInBtn.click();
        return new BudgetPage(appiumDriver);
    }
}