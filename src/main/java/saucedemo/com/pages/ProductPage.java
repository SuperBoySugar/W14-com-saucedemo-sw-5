package saucedemo.com.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import saucedemo.com.customlisteners.CustomListeners;
import saucedemo.com.utility.Utility;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productTitle;

    @CacheLookup
    @FindBy(xpath = "//img[starts-with(@class,'inventory_item_img')]")
    WebElement productList;


    public void verifyProductTitle(){
        Reporter.log("Verify Products Title: " +productTitle.toString() + "<br>");
        verifyText("Products",productTitle,"Product Title is not display");
        CustomListeners.test.log(Status.PASS,"Verify Text Product Title " );
    }

    // Verifying product page have 6 products
    public void verifyListOfProductsDisplayedOnPage() {
        int expectedNumberOfProducts = 6;   // Verify the 6 Products using List method
        List<WebElement> productList1 = driver.findElements(By.xpath("//img[starts-with(@class,'inventory_item_img')]"));
        int actualNumberOfProducts = productList1.size();
        Assert.assertEquals(expectedNumberOfProducts, actualNumberOfProducts, "Number of Products are not same");
    }

    // Verifying product page have 6 products
//    public void verifyListOfProductsDisplayedOnPage() {
//        int expectedNumberOfProducts = 6;   // Verify the 6 Products using List method
//        List<WebElement> productList1 = findElementsFromWebPage(productList);
//        int actualNumberOfProducts = productList1.size();
//        Assert.assertEquals(expectedNumberOfProducts, actualNumberOfProducts, "Number of Products are not same");
//    }
}
