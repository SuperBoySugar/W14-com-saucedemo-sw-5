package saucedemo.com.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import saucedemo.com.customlisteners.CustomListeners;
import saucedemo.com.utility.Utility;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement username;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void enterUserName(String name){
        Reporter.log("Enter User Name: " + username.toString() + "<br>");
        sendTextToElement(username, name);
        CustomListeners.test.log(Status.PASS,"Enter Username: " + name);
    }

    // Enter Password
    public void enterPassword(String password1) {
        Reporter.log("Enter Password: " + password.toString() + "<br>");
        sendTextToElement(password, password1);
        CustomListeners.test.log(Status.PASS,"Enter Password: " + password1);
    }

    // Click on Login Button
    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button: " + loginBtn.toString() + "<br>");
        pmClickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on Login button");
    }

}
