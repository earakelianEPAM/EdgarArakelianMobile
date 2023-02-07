package homework2;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.WebTest;

public class WebMobileTests extends WebTest {

    @Parameters({"searchItem"})
    @Test(description = "Searching item via Google search page produces some relevant results")
    public void googleSearchTest(String searchItem) {
        getGooglePageObject().open();
        getGooglePageObject().submitSearchItem(searchItem);

        int itemNumber = (int) getGoogleResultPageObject().getNumberSearchItem(searchItem);
        assertThat(itemNumber)
            .as("There should be multiple search results for a given item").isGreaterThan(0);
    }
}

