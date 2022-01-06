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

public class TC15 extends TestBase {
    String confirmPassword = Constant.PASSWORD;
    String pid = "123456789";
    String newUsernameTC15 = "Username" + Utilities.getDateAndTime() + "@mail.com";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(newUsernameTC15, Constant.PASSWORD, confirmPassword, pid);
    }

    @Test(description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page", dataProvider = "data-provider-TC15")
    public void TC15(String departStation, String arriveStation, int seatTypeHS, int seatTypeSS, int seatTypeSSC, int seatTypeHB, int seatTypeSB, int seatTypeSBC) {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(newUsernameTC15, Constant.PASSWORD);

        System.out.println("3. Click on \"Timetable\" tab");
        homePage.gotoTimetablePage();
        TimetablePage timetablePage = new TimetablePage();

        System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
        timetablePage.gotoCheckPriceLink(departStation, arriveStation);
        TicketPricePage ticketPricePage = new TicketPricePage();

        String actualTicketPricePageLabel = ticketPricePage.getTicketPricePageLabel();
        String expectedTicketPricePageLabel = "Ticket Price";
        Assert.assertEquals(actualTicketPricePageLabel, expectedTicketPricePageLabel, "Ticket Price Page label is not displayed as expected");

        String actualTableHeader = ticketPricePage.getTableHeader();
        String expectedTableHeader = "Ticket price from Đà Nẵng to Sài Gòn";
        Assert.assertEquals(actualTableHeader, expectedTableHeader, "Ticket table header is not displayed as expected");

        String actualHSPrice = ticketPricePage.getHSPrice();
        String expectedHSPrice = Integer.toString(seatTypeHS);
        Assert.assertEquals(actualHSPrice, expectedHSPrice, "HS price is not displayed as expected");

        String actualSSPrice = ticketPricePage.getSSPrice();
        String expectedSSPrice = Integer.toString(seatTypeSS);
        Assert.assertEquals(actualSSPrice, expectedSSPrice, "SS price is not displayed as expected");

        String actualSSCPrice = ticketPricePage.getSSCPrice();
        String expectedSSCPrice = Integer.toString(seatTypeSSC);
        Assert.assertEquals(actualSSCPrice, expectedSSCPrice, "SSC price is not displayed as expected");

        String actualHBPrice = ticketPricePage.getHBPrice();
        String expectedHBPrice = Integer.toString(seatTypeHB);
        Assert.assertEquals(actualHBPrice, expectedHBPrice, "HB price is not displayed as expected");

        String actualSBPrice = ticketPricePage.getSBPrice();
        String expectedSBPrice = Integer.toString(seatTypeSB);
        Assert.assertEquals(actualSBPrice, expectedSBPrice, "SB price is not displayed as expected");

        String actualSBCPrice = ticketPricePage.getSBCPrice();
        String expectedSBCPrice = Integer.toString(seatTypeSBC);
        Assert.assertEquals(actualSBCPrice, expectedSBCPrice, "SBC price is not displayed as expected");
    }

    @DataProvider(name = "data-provider-TC15")
    public Object[][] dataProvider() {
        String filePath = Constant.DATA_PATH;
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTC15.get("Depart Station").getAsString();
        String arriveStation = dataTC15.get("Arrive Station").getAsString();
        int seatTypeHS = dataTC15.get("HS").getAsInt();
        int seatTypeSS = dataTC15.get("SS").getAsInt();
        int seatTypeSSC = dataTC15.get("SSC").getAsInt();
        int seatTypeHB = dataTC15.get("HB").getAsInt();
        int seatTypeSB = dataTC15.get("SB").getAsInt();
        int seatTypeSBC = dataTC15.get("SBC").getAsInt();

        Object[][] object = new Object[][]{{departStation, arriveStation, seatTypeHS, seatTypeSS, seatTypeSSC, seatTypeHB, seatTypeSB, seatTypeSBC}};

        return object;
    }

}
