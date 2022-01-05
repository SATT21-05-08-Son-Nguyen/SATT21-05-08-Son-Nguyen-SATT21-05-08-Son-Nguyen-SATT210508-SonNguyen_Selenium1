package Railway;

import Common.Constant;
import Common.JsonHelper;
import Pageobjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC16 extends TestBase {

    @Test (description = "TC16 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC16(String departDate,String departStation,String arriveStation,String seatType,int ticketAmount) throws InterruptedException {
        System.out.println(String.format("%s - %s - %s - %s - %s", departDate, departStation, arriveStation, seatType, ticketAmount));

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.scrollRegPage();
        String newUsername = Constant.RANDOM_USERNAME;
        registerPage.register(newUsername,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(newUsername, Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        homePage.gotoBookTicketPage();
        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.scrollBookTicketPage();
        bookticketPage.selectDropdown(Constant.SEVEN_DAYS_AFTER_CURRENT_DAY,departStation,arriveStation,seatType,ticketAmount);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.scrollMyTicketPage();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        String amount = Integer.toString(ticketAmount);
        myTicketPage.cancelTicket(departStation,arriveStation,seatType,Constant.SEVEN_DAYS_AFTER_CURRENT_DAY,amount);

        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        Constant.WEBDRIVER.switchTo().alert().accept();
        Assert.assertFalse(myTicketPage.findCancelButton(departStation,arriveStation,seatType,Constant.SEVEN_DAYS_AFTER_CURRENT_DAY,amount), "Canceled ticket is still displayed, not as expected");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Constant.DATA_PATH;
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC14.get("Depart date").getAsString();
        String departStation = dataTC14.get("Depart from").getAsString();
        String arriveStation = dataTC14.get("Arrive at").getAsString();
        String seatType = dataTC14.get("Seat type").getAsString();
        int ticketAmount = dataTC14.get("Ticket amount").getAsInt();

        Object[][] object = new Object[][]{
                {departDate,departStation,arriveStation,seatType,ticketAmount}
        };

        return object;
    }
}
