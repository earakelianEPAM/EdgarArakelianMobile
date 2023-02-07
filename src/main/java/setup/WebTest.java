package setup;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pageObjects.webApp.GooglePageObject;
import pageObjects.webApp.GoogleResultPageObject;

public class WebTest {
    protected static AppiumDriver appiumDriver;
    protected GooglePageObject googlePageObject;
    protected GoogleResultPageObject googleResultPageObject;

    public AppiumDriver getDriver() {
        return appiumDriver;
    }
    public GooglePageObject getGooglePageObject() { return googlePageObject; }
    public GoogleResultPageObject getGoogleResultPageObject() { return googleResultPageObject; }

    @Parameters({"deviceName", "platformName", "browserName", "googleSearchPage"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String deviceName, String platformName, String browserName, String googleSearchPage) {
        setAppiumDriver(deviceName, platformName, browserName);
        googlePageObject = new GooglePageObject(appiumDriver,googleSearchPage);
        googleResultPageObject = new GoogleResultPageObject(appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String deviceName,
                                 String platformName,
                                 String browserName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("browserName", browserName);

        try {
            appiumDriver = new AppiumDriver(
                new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        appiumDriver.manage().timeouts()
                    .pageLoadTimeout(1, TimeUnit.MINUTES)
                    .implicitlyWait(20, TimeUnit.SECONDS);
    }
}
