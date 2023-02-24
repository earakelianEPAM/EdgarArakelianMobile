package pages.nativepage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public AppiumDriver appiumDriver;
    protected final static String APPLIC_NAME_ID = "platkovsky.alexey.epamtestapp:id/";

    public MainPage (AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
