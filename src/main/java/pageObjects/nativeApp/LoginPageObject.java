package pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class LoginPageObject extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement passwordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerButton;

    public LoginPageObject(AppiumDriver appiumDriver) { super(appiumDriver); }

    public RegistrationPageObject openRegistrationPage() {
        waitUntilElementIsClickable(registerButton);
        registerButton.click();

        return new RegistrationPageObject(appiumDriver);
    }

    public BudgetPageObject signIn(String email, String password) {
        waitUntilElementIsVisible(loginField);
        loginField.sendKeys(email);
        waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        waitUntilElementIsClickable(signInButton);
        signInButton.click();

        return new BudgetPageObject(appiumDriver);
    }
}
