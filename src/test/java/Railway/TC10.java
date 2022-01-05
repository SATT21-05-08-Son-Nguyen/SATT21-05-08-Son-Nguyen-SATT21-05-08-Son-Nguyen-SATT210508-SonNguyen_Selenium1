package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase{

    @Test (description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.scrollRegPage();
        String newUsername = Constant.RANDOM_USERNAME;
        registerPage.register(newUsername,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();
        registerPage = new RegisterPage();
        registerPage.scrollRegPage();

        System.out.println("3. Enter information of the created account in Pre-condition");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(newUsername,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        registerPage.scrollRegPage();

        String actualRegErrorMsg = registerPage.getRegErrorMsg();
        String expectedRegErrorMsg = "This email address is already in use.";
        Assert.assertEquals(actualRegErrorMsg, expectedRegErrorMsg, "Error message is not displayed as expected");
    }
}
