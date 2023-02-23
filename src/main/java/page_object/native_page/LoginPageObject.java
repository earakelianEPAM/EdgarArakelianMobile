package page_object.native_page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends MainPage {

    @AndroidFindBy(id = APPLIC_NAME_ID + "email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;

    @AndroidFindBy(id = APPLIC_NAME_ID + "register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerButton;

    @AndroidFindBy(id = APPLIC_NAME_ID + "login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement emailField;

    @AndroidFindBy(id = APPLIC_NAME_ID + "login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordField;

    public LoginPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void pushRegisterAccountButton () {
        registerButton.click();
    }

    public void enterEmail (String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }

    public void pushSignInButton() {
        signInBtn.click();
    }
}