package setup;
import static properties.CloudProperty.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePageObject;

public class BaseSettings {

    protected static AppiumDriver appiumDriver; // singleton
    private static IPageObject pageObject;
    WebDriverWait webDriverWait;

    public static AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return this.pageObject;
    }

    private static void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new BasePageObject(appType, appiumDriver);
    }

    public static DesiredCapabilities getDesiredCapabilities (String platformName, String deviceName, String udid,
                                                              String app, String browserName, String appPackage,
                                                              String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability(MobileCapabilityType.APP, (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);

        return capabilities;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "app", "browserName", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String app,
                      @Optional("") String browserName,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId

    ) throws Exception {
        DesiredCapabilities capabilities =
                getDesiredCapabilities(platformName, deviceName, udid, app, browserName, appPackage, appActivity, bundleId);
        setAppiumDriver(capabilities);
        setPageObject(appType, appiumDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(DesiredCapabilities capabilities) {
        try {
            String fullUrl = String.format("https://%s:%s@%s/wd/hub",
                    EMAIL, API_KEY, APPIUM_HUB);
            appiumDriver = new AppiumDriver(new URL(fullUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected WebDriverWait waitDriver() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(getDriver(), 10);
        }
        return webDriverWait;
    }
}