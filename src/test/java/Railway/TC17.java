package Railway;

import Common.Constant;
import Common.JsonHelper;
import Pageobjects.Railway.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC17 extends TestBase {

    @Test (description = "TC17 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC17(String departDate1,String departStation1,String arriveStation1,String seatType1,int ticketAmount1,String departDate2,String departStation2,String arriveStation2,String seatType2,int ticketAmount2) throws InterruptedException {
        System.out.println(String.format("%s - %s - %s - %s - %s - %s - %s - %s - %s - %s",departDate1,departStation1,arriveStation1,seatType1,ticketAmount1,departDate2,departStation2,arriveStation2,seatType2,ticketAmount2));

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

        System.out.println("4. Book 10 tickets");
        bookticketPage.selectDropdown(Constant.SEVEN_DAYS_AFTER_CURRENT_DAY,departStation1,arriveStation1,seatType1,ticketAmount1);

        System.out.println("5. Click on \"Book ticket\" tab again");
        homePage.gotoBookTicketPage();
        bookticketPage = new BookTicketPage();
        bookticketPage.scrollBookTicketPage();

        System.out.println("6. Book one more ticket");
        bookticketPage.selectDropdown(Constant.SEVEN_DAYS_AFTER_CURRENT_DAY,departStation2,arriveStation2,seatType2,ticketAmount2);

        String actualBTKErrorMsg = bookticketPage.getBookTicketPageErrorMsg();
        String expectedBTKErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualBTKErrorMsg, expectedBTKErrorMsg, "Error message is not displayed as expected");

        String actualTicketAmountErrorMsg = bookticketPage.getTicketAmountErrorMsg();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Error message is not displayed as expected");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Constant.DATA_PATH;
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC17.get("Depart date 1").getAsString();
        String departStation1 = dataTC17.get("Depart from 1").getAsString();
        String arriveStation1 = dataTC17.get("Arrive at 1").getAsString();
        String seatType1 = dataTC17.get("Seat type 1").getAsString();
        int ticketAmount1 = dataTC17.get("Ticket amount 1").getAsInt();
        String departDate2 = dataTC17.get("Depart date 2").getAsString();
        String departStation2 = dataTC17.get("Depart from 2").getAsString();
        String arriveStation2 = dataTC17.get("Arrive at 2").getAsString();
        String seatType2 = dataTC17.get("Seat type 2").getAsString();
        int ticketAmount2 = dataTC17.get("Ticket amount 2").getAsInt();

        Object[][] object = new Object[][]{
                {departDate1,departStation1,arriveStation1,seatType1,ticketAmount1,departDate2,departStation2,arriveStation2,seatType2,ticketAmount2}
        };

        return object;
    }
}
