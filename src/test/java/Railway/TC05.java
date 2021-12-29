package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase{

    @Test (description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("3. Enter valid Email and Password");
        System.out.println("4. Click on \"Login\" button");
        System.out.println("5. Repeat step 3 three more times.");
        loginPage.loginMultipletimes(Constant.USERNAME, Constant.INVALIDPASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
