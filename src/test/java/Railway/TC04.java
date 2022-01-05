package Railway;

import Common.Constant;
import Pageobjects.Railway.BookTicketPage;
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
        homePage.gotoBookTicketPage();
        LoginPage loginPage = new LoginPage();

        String actualLoginPageTitle = "Login Page";
        String expectedLoginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "Login page is not displayed as expected");

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookticketPage = new BookTicketPage();
        Assert.assertTrue(bookticketPage.findBookTicketFormLabel(), "Book ticket form does not open as expected");
    }
}
