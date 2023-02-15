package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.web.WebPageObject;

public class webMobileTest extends BaseSetting {

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
