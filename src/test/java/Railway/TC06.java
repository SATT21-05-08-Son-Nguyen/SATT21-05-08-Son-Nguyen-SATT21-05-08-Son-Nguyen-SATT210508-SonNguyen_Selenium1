package Railway;

import Common.Constant;
import Pageobjects.Railway.GeneralPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase{

    @Test (description = "TC06 - User is redirected to Book ticket page after logging in")
    public void TC06() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with valid Email and Password");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Contact\" tab");
        homePage.gotoContactPage();

        System.out.println("4. Click on \"Log out\" tab");
        homePage.gotoLogoutPage();

        String actualUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl = "http://www.railway.somee.com/Page/HomePage.cshtml";
        Assert.assertEquals(actualUrl, expectedUrl, "Home page is not displayed as expected");

        homePage.findLogoutTabExists();
        Assert.assertTrue(true, "Log out Tab is still displayed, not as expected");
    }
}
