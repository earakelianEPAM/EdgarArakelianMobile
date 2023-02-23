package page_object.native_page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.BaseSettings;

public class RegistrationPage extends MainPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Registration']")
    public static WebElement registrationHeader;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement registrationEmailField;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement registrationUserNameField;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordField;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement confirmPasswordField;

    @AndroidFindBy(id = APPLIC_NAME_ID + "register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    public WebElement registerNewAccountButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value='0']")
    public WebElement agreementToggle;

    public RegistrationPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void enterEmail(String email) {
        registrationEmailField.sendKeys(email);
    }

    public void enterUsername(String userName) {
        registrationUserNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void pushRegisterButton() {

        String platformName = (String) BaseSettings.getDriver().getCapabilities().getCapability("platformName");
        if (platformName.equals("iOS")) {
            agreementToggle.click();
            registerNewAccountButton.click();
        }
        registerNewAccountButton.click();
    }
}