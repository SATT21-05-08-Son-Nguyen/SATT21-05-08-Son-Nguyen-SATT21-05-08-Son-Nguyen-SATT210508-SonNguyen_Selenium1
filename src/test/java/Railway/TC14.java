package Railway;

import Common.Constant;
import Common.JsonHelper;
import Pageobjects.Railway.BookTicketPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import Pageobjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC14 extends TestBase {

    @Test (description = "TC14 - User can book many tickets at a time", dataProvider = "data-provider")
    public void TC14(String departDate,String departStation,String arriveStation,String seatType,int ticketAmount) throws InterruptedException {
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

        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();
        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.scrollBookTicketPage();

        System.out.println("4. Select a \"Depart date\" from the list");
        System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
        System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
        System.out.println("7. Select \"5\" for \"Ticket amount\"");
        System.out.println("8. Click on \"Book ticket\" button");
        String ticketDepartDate = Constant.SEVEN_DAYS_AFTER_CURRENT_DAY;
        bookticketPage.selectDropdown(ticketDepartDate,departStation,arriveStation,seatType,ticketAmount);

        String actualConfirmMsg = bookticketPage.getConfirmMsg();
        String expectedConfirmMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg, "Confirm message is not displayed as expected");

        String actualDepartDate = bookticketPage.getDepartDateAfterBooking();
        String expectedDepartDate = ticketDepartDate;
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart Date is not displayed as expected");

        String actualDepartStation = bookticketPage.getDepartStationAfterBooking();
        String expectedDepartStation = departStation;
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected");

        String actualArriveStation = bookticketPage.getArriveStationAfterBooking();
        String expectedArriveStation = arriveStation;
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected");

        String actualSeatType = bookticketPage.getSeatTypeAfterBooking();
        String expectedSeatType = seatType;
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat Type is not displayed as expected");

        String actualAmount = bookticketPage.getAmountAfterBooking();
        String expectedAmount = Integer.toString(ticketAmount);
        Assert.assertEquals(actualAmount, expectedAmount, "Amount is not displayed as expected");
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
