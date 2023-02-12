package pageObjects.nativeTest;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends MainPage {

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_email")
    private WebElement regEmailInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_username")
    private WebElement regUserNameInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_password")
    private WebElement regPassInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "registration_confirm_password")
    private WebElement regRepPassInput;

    @AndroidFindBy(id = APPLIC_NAME_ID + "register_new_account_button")
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
