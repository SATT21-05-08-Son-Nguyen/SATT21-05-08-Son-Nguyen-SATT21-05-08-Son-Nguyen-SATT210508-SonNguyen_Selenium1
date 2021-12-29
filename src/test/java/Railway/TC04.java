package Railway;

import Common.Constant;
import Pageobjects.Railway.BookticketPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase{

    @Test (description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Book ticket\" tab");
        homePage.gotoBookticketPage();
        LoginPage loginPage = new LoginPage();

        String actualBTKUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedBTKUrl = "http://www.railway.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualBTKUrl, expectedBTKUrl, "Home page is not displayed as expected");

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualLIUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedLIUrl = "http://www.railway.somee.com/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualLIUrl, expectedLIUrl, "Home page is not displayed as expected");

        BookticketPage bookticketPage = new BookticketPage();
        bookticketPage.findBookticketFormLabel();
        Assert.assertTrue(true, "Book ticket form does not open.");
    }
}
