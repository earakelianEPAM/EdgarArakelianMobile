package page_object.native_page;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page_object.util.Util;

public class RegistrationPage extends Util {

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement regEmailInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private WebElement regUserNameInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement regPassInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private WebElement regRepPassInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private WebElement regButton;

    public RegistrationPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationPage registerNewUser(User user, AppiumDriver appiumDriver) {
        regEmailInput.sendKeys(user.getEmail());
        regUserNameInput.sendKeys(user.getUserName());
        regPassInput.sendKeys(user.getPassword());
        regRepPassInput.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        regButton.click();
        return this;
    }
}