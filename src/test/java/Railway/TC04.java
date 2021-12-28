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
        String actualLogintitle = loginPage.getLoginTitle();
        String expectedLoginTitle = "Login page";
        Assert.assertEquals(actualLogintitle, expectedLoginTitle, "Login page is not displayed as expected");

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookticketPage bookticketPage = new BookticketPage();
        String actualBookticketTitle = bookticketPage.getBookticketPageTitle();
        String expectedBookticketTitle = "Book ticket";
        Assert.assertEquals(actualBookticketTitle, expectedBookticketTitle, "Book ticket page is not displayed as expected");
    }
}
