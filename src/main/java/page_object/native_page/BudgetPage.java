package page_object.native_page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.util.BaseSettings;


public class BudgetPage extends BaseSettings {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
    public static WebElement budgetActionBarText;

    @AndroidFindBy(id = APPLIC_NAME_ID + "add_new_expense")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Add']")
    private WebElement addExpenseBtn;

    public BudgetPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForBudgetPageIsLoaded() {
        new WebDriverWait(appiumDriver, 60)
                .until(ExpectedConditions.visibilityOf(addExpenseBtn));
    }

}
