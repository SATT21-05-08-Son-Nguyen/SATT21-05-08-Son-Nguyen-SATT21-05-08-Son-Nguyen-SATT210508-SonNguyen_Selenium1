package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase{

    @Test (description = "TC02 - User can't login with blank \"Username\" textbox")
    public void TC02() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
