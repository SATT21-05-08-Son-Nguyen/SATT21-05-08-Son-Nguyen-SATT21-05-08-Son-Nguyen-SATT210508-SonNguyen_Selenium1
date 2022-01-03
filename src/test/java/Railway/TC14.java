package Railway;

import Common.Constant;
import Pageobjects.Railway.BookticketPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TC14 extends TestBase {

    @Test (description = "TC14 - User can book many tickets at a time", dataProvider = "dp")
    public void TC14(String data) throws InterruptedException {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookticketPage();
        BookticketPage bookticketPage = new BookticketPage();
        bookticketPage.scrollBookTicketPage();
        String ticketInfo[] = data.split(",");
        bookticketPage.selectDropdown(ticketInfo[0],ticketInfo[1],ticketInfo[2],ticketInfo[3],ticketInfo[4]);

        String actualConfirmMsg = bookticketPage.getConfirmMsg();
        String expectedConfirmMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg, "Confirm message is not displayed as expected");

        String actualDepartDate = bookticketPage.getDepartDateAfterBooking();
        String expectedDepartDate = ticketInfo[0];
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart Date is not displayed as expected");

        String actualDepartStation = bookticketPage.getDepartStationAfterBooking();
        String expectedDepartStation = ticketInfo[1];
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected");

        String actualArriveStation = bookticketPage.getArriveStationAfterBooking();
        String expectedArriveStation = ticketInfo[2];
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected");

        String actualSeatType = bookticketPage.getSeatTypeAfterBooking();
        String expectedSeatType = ticketInfo[3];
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat Type is not displayed as expected");

        String actualAmount = bookticketPage.getAmountAfterBooking();
        String expectedAmount = ticketInfo[4];
        Assert.assertEquals(actualAmount, expectedAmount, "Amount is not displayed as expected");
    }

    @DataProvider(name="dp")
    public String[] readJson() throws IOException,ParseException{
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\src\\main\\resources\\jsonfiles\\BookTicketData.json");

        Object obj = jsonParser.parse(reader);

        JSONObject bookTicketJsonObj = (JSONObject) obj;
        JSONArray bookTicketArray = (JSONArray) bookTicketJsonObj.get("TC14");

        String arr[] = new String[bookTicketArray.size()];

        for (int i=0; i<bookTicketArray.size();i++)
        {
            JSONObject ticketInfo = (JSONObject) bookTicketArray.get(i);
            String DepartDate = (String) ticketInfo.get("Depart date");
            String DepartFrom = (String) ticketInfo.get("Depart from");
            String ArriveAt = (String) ticketInfo.get("Arrive at");
            String SeatType = (String) ticketInfo.get("Seat type");
            String TicketAmount = (String) ticketInfo.get("Ticket amount");

            arr[i] = DepartDate + "," + DepartFrom + "," + ArriveAt + "," + SeatType + "," + TicketAmount;
        }
        return arr;
    }
}
