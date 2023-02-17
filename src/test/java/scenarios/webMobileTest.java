package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object.util.BaseSettings;
import page_object.web.WebPageObject;

import java.util.List;

public class webMobileTest extends BaseSettings {
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "webDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"web"},
            description = "Make sure that there are some relevant results")
    public void WebTest(String googlePageStr, String searchStr) {
        WebPageObject googlePage = (WebPageObject) getPo().getPageObject();
        googlePage.openPage(googlePageStr);
        googlePage.clickOnCockiesButton(getDriver());
        googlePage.search(searchStr);
        List<WebElement> searchResults = googlePage.getSearchList();

        for (WebElement searchItem : searchResults) {
            System.out.println(searchItem.getText());
            softAssert.assertTrue(searchItem.getText(). contains(searchStr));
        }
        softAssert.assertAll();    }
}
