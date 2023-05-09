package saucedemo.com.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import saucedemo.com.customlisteners.CustomListeners;
import saucedemo.com.pages.HomePage;
import saucedemo.com.pages.ProductPage;
import saucedemo.com.testbase.BaseTest;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void inIt() {
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void userSholdLoginSuccessfullyWithValidCredentials(String username, String password) {
        // enter Username
        homePage.enterUserName(username);
        // Enter Password
        homePage.enterPassword(password);
        // Click on Login Button
        homePage.clickOnLoginButton();
        // verify Product Title on Product Page
        productPage.verifyProductTitle();
        // Verifying product page have 6 products
        productPage.verifyListOfProductsDisplayedOnPage();
    }

    @Test(groups = {"smoke"}, dataProvider = "credentials", dataProviderClass = TestData.class)
    public void verifyThatSixProductsAreDisplayedOnPage(String username, String password) {
        // enter Username
        homePage.enterUserName(username);
        // Enter Password
        homePage.enterPassword(password);
        // Click on Login Button
        homePage.clickOnLoginButton();
    }

}