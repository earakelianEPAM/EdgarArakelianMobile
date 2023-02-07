package pageObjects.nativeApp;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class BudgetPageObject extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/expenses_list")
    private WebElement expensesList;

    public BudgetPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void assertExpensesListExists() {
        assertThat(expensesList).as("There should be 'Expenses list' element on the page").isNotNull();
    }
}
