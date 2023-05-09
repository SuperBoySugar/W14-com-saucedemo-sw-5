package saucedemo.com.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import saucedemo.com.propertyreader.PropertyReader;
import saucedemo.com.utility.Utility;

/**
 * Created by Jay Vaghani
 */
public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod (groups = {"sanity", "smoke", "regression"})
    public void tearDown(){
        closeBrowser();
    }
}
