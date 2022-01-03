package Railway;

import Common.Constant;
import Pageobjects.Railway.BookticketPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import Pageobjects.Railway.MyTicketPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TC16 extends TestBase {

    @Test (description = "TC16 - User can cancel a ticket", dataProvider = "dp")
    public void TC16(String data) throws InterruptedException {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        homePage.gotoBookticketPage();
        BookticketPage bookticketPage = new BookticketPage();
        bookticketPage.scrollBookTicketPage();
        String ticketInfo[] = data.split(",");
        bookticketPage.selectDropdown(ticketInfo[0],ticketInfo[1],ticketInfo[2],ticketInfo[3],ticketInfo[4]);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.scrollMyTicketPage();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.cancelTicket(ticketInfo[1],ticketInfo[2],ticketInfo[3],ticketInfo[0],ticketInfo[4]);

        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        Assert.assertFalse(myTicketPage.findCancelButton(ticketInfo[1],ticketInfo[2],ticketInfo[3],ticketInfo[0],ticketInfo[4]), "Canceled ticket is still displayed, not as expected");
    }

    @DataProvider(name="dp")
    public String[] readJson() throws IOException,ParseException{
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\src\\main\\resources\\jsonfiles\\BookTicketData.json");

        Object obj = jsonParser.parse(reader);

        JSONObject bookTicketJsonObj = (JSONObject) obj;
        JSONArray bookTicketArray = (JSONArray) bookTicketJsonObj.get("TC16");

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
