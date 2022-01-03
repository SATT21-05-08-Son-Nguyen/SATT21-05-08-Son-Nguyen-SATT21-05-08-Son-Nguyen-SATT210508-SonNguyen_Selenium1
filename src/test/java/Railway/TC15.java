package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import Pageobjects.Railway.TicketPricePage;
import Pageobjects.Railway.TimetablePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TC15 extends TestBase{

    @Test (description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page", dataProvider = "dp")
    public void TC15(String data) throws InterruptedException {
        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Timetable\" tab");
        homePage.gotoTimetablePage();
        TimetablePage timetablePage = new TimetablePage();
        String ticketPriceInfo[] = data.split(",");

        System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
        timetablePage.gotoCheckPriceLink(ticketPriceInfo[0],ticketPriceInfo[1]);
        TicketPricePage ticketPricePage = new TicketPricePage();

        String actualTicketPricePageLabel = ticketPricePage.getTicketPricePageLabel();
        String expectedTicketPricePageLabel = "Ticket Price";
        Assert.assertEquals(actualTicketPricePageLabel, expectedTicketPricePageLabel, "Ticket Price Page label is not displayed as expected");

        String actualTableHeader = ticketPricePage.getTableHeader();
        String expectedTableHeader = "Ticket price from Sài Gòn to Phan Thiết";
        Assert.assertEquals(actualTableHeader, expectedTableHeader, "Table header is not displayed as expected");

        String actualHSPrice = ticketPricePage.getHSPrice();
        String expectedHSPrice = ticketPriceInfo[2];
        Assert.assertEquals(actualHSPrice, expectedHSPrice, "HS price is not displayed as expected");

        String actualSSPrice = ticketPricePage.getSSPrice();
        String expectedSSPrice = ticketPriceInfo[3];
        Assert.assertEquals(actualSSPrice, expectedSSPrice, "SS price is not displayed as expected");

        String actualSSCPrice = ticketPricePage.getSSCPrice();
        String expectedSSCPrice = ticketPriceInfo[4];
        Assert.assertEquals(actualSSCPrice, expectedSSCPrice, "SSC price is not displayed as expected");

        String actualHBPrice = ticketPricePage.getHBPrice();
        String expectedHBPrice = ticketPriceInfo[5];
        Assert.assertEquals(actualHBPrice, expectedHBPrice, "HB price is not displayed as expected");

        String actualSBPrice = ticketPricePage.getSBPrice();
        String expectedSBPrice = ticketPriceInfo[6];
        Assert.assertEquals(actualSBPrice, expectedSBPrice, "SB price is not displayed as expected");

        String actualSBCPrice = ticketPricePage.getSBCPrice();
        String expectedSBCPrice = ticketPriceInfo[7];
        Assert.assertEquals(actualSBCPrice, expectedSBCPrice, "SBC price is not displayed as expected");
    }

    @DataProvider(name="dp")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\src\\main\\resources\\jsonfiles\\TicketPriceData.json");

        Object obj = jsonParser.parse(reader);

        JSONObject ticketPriceJsonObj = (JSONObject) obj;
        JSONArray ticketPriceArray = (JSONArray) ticketPriceJsonObj.get("TC15");

        String arr[] = new String[ticketPriceArray.size()];

        for (int i=0; i<ticketPriceArray.size();i++)
        {
            JSONObject ticketInfo = (JSONObject) ticketPriceArray.get(i);
            String DepartStation = (String) ticketInfo.get("Depart Station");
            String ArriveStation = (String) ticketInfo.get("Arrive Station");
            String HS = (String) ticketInfo.get("HS");
            String SS = (String) ticketInfo.get("SS");
            String SSC = (String) ticketInfo.get("SSC");
            String HB = (String) ticketInfo.get("HB");
            String SB = (String) ticketInfo.get("SB");
            String SBC = (String) ticketInfo.get("SBC");

            arr[i] = DepartStation + "," + ArriveStation + "," + HS + "," + SS + "," + SSC + "," + HB + "," + SB + "," + SBC;
        }
        return arr;
    }
}
