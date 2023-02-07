package pageObjects.webApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.AbstractPageObject;

public class GooglePageObject extends AbstractPageObject {
    private final String baseUrl;

    @FindBy(css = "input[aria-autocomplete]")
    private WebElement searchForm;

    public GooglePageObject(AppiumDriver appiumDriver, String searchPageUrl) {
        super(appiumDriver);
        baseUrl = searchPageUrl;
    }

    public void open() {
        appiumDriver.navigate().to(baseUrl);
    }

    public GoogleResultPageObject submitSearchItem(String searchItem) {
        waitUntilElementIsVisible(searchForm);
        searchForm.sendKeys(searchItem, Keys.ENTER);
        waitUntilDocumentFullyLoads();
        return new GoogleResultPageObject(appiumDriver);
    }
}
