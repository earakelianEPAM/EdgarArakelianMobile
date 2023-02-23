package page_object.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.native_page.MainPage;

import java.util.List;

public class WebPageObject extends MainPage {

    @FindBy(css = "div[id='rso'] div[role='heading'][aria-level='3']")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='W0wltc']")
    private WebElement acceptAllCookiesButton;

    public WebPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public WebPageObject openPage(String url) {
        appiumDriver.navigate().to(url);
        new WebDriverWait(appiumDriver, 10).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public WebElement getAcceptAllButton() {
        return acceptAllCookiesButton;
    }

    public void clickOnCockiesButton(AppiumDriver appiumDriver) {
        appiumDriver.executeScript("arguments[0].scrollIntoView(false)", getAcceptAllButton());
        appiumDriver.executeScript("arguments[0].click();", getAcceptAllButton());
    }

    public WebPageObject search(String searchStr) {
        searchField.sendKeys(searchStr);
        searchField.sendKeys(Keys.ENTER);
        new WebDriverWait(appiumDriver, 20).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public List<WebElement> getSearchList() {
        return searchResultList;
    }
}
