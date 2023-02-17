package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.webTest.WebPageObject;
import properties.MobileDataProvider;
import setup.BaseTest;

import java.util.List;

public class webMobileTests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "webDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"web"},
            description = "Make sure that there are some relevant results")
    public void WebTest(String googlePageStr, String searchStr) {
        WebPageObject googlePage = (WebPageObject) getPo().getPageObject();
        googlePage.openPage(googlePageStr);
        googlePage.search(searchStr);

        List<WebElement> searchResults = googlePage.getSearchList();

        for (WebElement searchItem : searchResults) {
        softAssert.assertTrue(searchItem.getText(). contains(searchStr));
        }
        softAssert.assertAll();

    }
}
