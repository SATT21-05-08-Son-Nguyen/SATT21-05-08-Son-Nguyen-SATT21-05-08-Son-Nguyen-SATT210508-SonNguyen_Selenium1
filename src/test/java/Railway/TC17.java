package Railway;

import Common.Constant;
import Pageobjects.Railway.BookTicketPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase {

    @Test (description = "TC17 - User can't book more than 10 tickets")
    public void TC17() throws InterruptedException {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.scrollBookTicketPage();

        System.out.println("4. Book 10 tickets");
        bookticketPage.selectDropdown("1/29/2022","Nha Trang","Sài Gòn","Soft seat with air conditioner","10");

        System.out.println("5. Click on \"Book ticket\" tab again");
        homePage.gotoBookTicketPage();
        bookticketPage = new BookTicketPage();
        bookticketPage.scrollBookTicketPage();

        System.out.println("6. Book one more ticket");
        bookticketPage.selectDropdown("1/27/2022","Sài Gòn","Phan Thiết","Hard bed","1");

        String actualBTKErrorMsg = bookticketPage.getBookTicketPageErrorMsg();
        String expectedBTKErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualBTKErrorMsg, expectedBTKErrorMsg, "Error message is not displayed as expected");

        String actualTicketAmountErrorMsg = bookticketPage.getTicketAmountErrorMsg();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Error message is not displayed as expected");
    }
}
