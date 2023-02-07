package pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class RegistrationPageObject extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement emailField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement usernameField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement passwordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPasswordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement registerNewAccountButton;

    public RegistrationPageObject(AppiumDriver appiumDriver) { super(appiumDriver); }

    public LoginPageObject registerUser(String email, String username, String password) {
        waitUntilElementIsVisible(emailField);
        emailField.sendKeys(email);
        waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        waitUntilElementIsVisible(confirmPasswordField);
        confirmPasswordField.sendKeys(password);

        appiumDriver.hideKeyboard();

        waitUntilElementIsClickable(registerNewAccountButton);
        registerNewAccountButton.click();

        return new LoginPageObject(appiumDriver);
    }
}
