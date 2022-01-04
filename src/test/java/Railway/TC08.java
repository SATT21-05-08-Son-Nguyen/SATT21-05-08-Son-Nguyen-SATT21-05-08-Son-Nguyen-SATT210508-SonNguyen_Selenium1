package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase{

    @Test (description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("Pre-condition: Create a new account but do not activate it");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.ScrollRegPage();
        String randomUsername = Constant.RANDOMUSERNAME;
        registerPage.register(randomUsername,Constant.PASSWORD,Constant.COMFIRMPASSWORD,Constant.PID);

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("3. Enter username and password of account hasn't been activated.");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login(randomUsername, Constant.PASSWORD);

        String actualWelcomeMsg = homePage.getWelcomeMessage();
        String expectedWelcomeMsg = "Welcome " + randomUsername;
        Assert.assertNotEquals(actualWelcomeMsg, expectedWelcomeMsg, "User has logged in successfully, not as expected");

        loginPage.findErrorMsg();
        Assert.assertTrue(false, "Error message is not displayed");

        String actualErrorMsg = loginPage.getLoginErrorMsg();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}
