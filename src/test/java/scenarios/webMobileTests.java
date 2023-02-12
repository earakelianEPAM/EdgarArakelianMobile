package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.webTest.WebPageObject;
import properties.MobileDataProvider;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(dataProvider = "webDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"web"},
            description = "Make sure that there are some relevant results")
    public void WebTest(String googlePageStr, String searchStr) {
        WebPageObject googlePage = (WebPageObject) getPo().getPageObject();
        googlePage.openPage(googlePageStr);
        googlePage.search(searchStr);
        Assert.assertTrue(googlePage.searchResultContainsText(searchStr), "No results");
    }
}
