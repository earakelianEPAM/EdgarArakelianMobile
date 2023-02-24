package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.nativepage.LoginPageObject;
import pages.webpage.WebPageObject;
import setup.IPageObject;

import java.lang.reflect.Field;

public class BasePageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements

    public BasePageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new LoginPageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }
    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }

    @Override
    public Object getPageObject() {
        return this.somePageObject;
    }
}
