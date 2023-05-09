package saucedemo.com.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import saucedemo.com.browserfactory.ManageBrowser;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Utility extends ManageBrowser {

    /**
     * This method will click on element
     *
     * @ param by
     */
    public void pmClickOnElement(WebElement element) {
       element.click();
    }

    /**
     * This method will get text from element
     */
    public String doGetTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);

    }



    /**
     * This Method will verify text using Assert
     */
    public void verifyText(String expectedMessage, WebElement element, String displayMessage) {
        String actualMessage = doGetTextFromElement(element);
        Assert.assertEquals(actualMessage, expectedMessage, displayMessage);
    }


    /**
     * This method will get the list of elements
     */
//    public List<WebElement> findElementsFromWebPage(WebElement element){
//        return ;
//    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

}
