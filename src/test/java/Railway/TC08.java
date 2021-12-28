package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase{

    @Test (description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("3. Enter username and password of account hasn't been activated.");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
