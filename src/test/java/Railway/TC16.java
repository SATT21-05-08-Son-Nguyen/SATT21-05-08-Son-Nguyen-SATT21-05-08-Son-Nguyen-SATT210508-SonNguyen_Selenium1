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

public class TC16 extends TestBase {
    String confirmPassword = Constant.PASSWORD;
    String pid = "123456789";
    String ticketDepartDate = Utilities.getFutureDate(7);
    String newUsernameTC16 = "Username" + Utilities.getDateAndTime() + "@mail.com";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(newUsernameTC16, Constant.PASSWORD, confirmPassword, pid);
    }

    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider-TC16")
    public void TC16(String departStation, String arriveStation, String seatType, int ticketAmount) {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(newUsernameTC16, Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        homePage.gotoBookTicketPage();
        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.selectDropdown(ticketDepartDate, departStation, arriveStation, seatType, ticketAmount);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        String amount = Integer.toString(ticketAmount);
        myTicketPage.cancelTicket(departStation, arriveStation, seatType, ticketDepartDate, amount);

        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        Assert.assertFalse(myTicketPage.findCancelButton(departStation, arriveStation, seatType, ticketDepartDate, amount), "Canceled ticket is still displayed, not as expected");
    }

    @DataProvider(name = "data-provider-TC16")
    public Object[][] dataProvider() {
        String filePath = Constant.DATA_PATH;
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC14.get("Depart from").getAsString();
        String arriveStation = dataTC14.get("Arrive at").getAsString();
        String seatType = dataTC14.get("Seat type").getAsString();
        int ticketAmount = dataTC14.get("Ticket amount").getAsInt();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };

        return object;
    }
}
