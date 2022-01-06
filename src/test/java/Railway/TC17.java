package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import Pageobjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    String confirmPassword = Constant.PASSWORD;
    String pid = "123456789";
    String ticketDepartDate = Utilities.getFutureDate(7);
    String newUsernameTC17 = "Username" + Utilities.getDateAndTime() + "@mail.com";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(newUsernameTC17, Constant.PASSWORD, confirmPassword, pid);
    }

    @Test(description = "TC17 - User can cancel a ticket", dataProvider = "data-provider-TC17")
    public void TC17(String departStation1, String arriveStation1, String seatType1, int ticketAmount1, String departStation2, String arriveStation2, String seatType2, int ticketAmount2) {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(newUsernameTC17, Constant.PASSWORD);

        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        BookTicketPage bookticketPage = new BookTicketPage();

        System.out.println("4. Book 10 tickets");
        bookticketPage.selectDropdown(ticketDepartDate, departStation1, arriveStation1, seatType1, ticketAmount1);

        System.out.println("5. Click on \"Book ticket\" tab again");
        homePage.gotoBookTicketPage();
        bookticketPage = new BookTicketPage();

        System.out.println("6. Book one more ticket");
        bookticketPage.selectDropdown(ticketDepartDate, departStation2, arriveStation2, seatType2, ticketAmount2);

        String actualBTKErrorMsg = bookticketPage.getBookTicketPageErrorMsg();
        String expectedBTKErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualBTKErrorMsg, expectedBTKErrorMsg, "Error message is not displayed as expected");

        String actualTicketAmountErrorMsg = bookticketPage.getTicketAmountErrorMsg();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Error message is not displayed as expected");
    }

    @DataProvider(name = "data-provider-TC17")
    public Object[][] dataProvider() {
        String filePath = Constant.DATA_PATH;
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation1 = dataTC17.get("Depart from 1").getAsString();
        String arriveStation1 = dataTC17.get("Arrive at 1").getAsString();
        String seatType1 = dataTC17.get("Seat type 1").getAsString();
        int ticketAmount1 = dataTC17.get("Ticket amount 1").getAsInt();
        String departStation2 = dataTC17.get("Depart from 2").getAsString();
        String arriveStation2 = dataTC17.get("Arrive at 2").getAsString();
        String seatType2 = dataTC17.get("Seat type 2").getAsString();
        int ticketAmount2 = dataTC17.get("Ticket amount 2").getAsInt();

        Object[][] object = new Object[][]{
                {departStation1, arriveStation1, seatType1, ticketAmount1, departStation2, arriveStation2, seatType2, ticketAmount2}
        };

        return object;
    }
}
