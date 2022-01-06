package Railway;

import Common.Constant;
import Common.Utilities;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    String confirmPassword = Constant.PASSWORD;
    String pid = "123456789";
    String newUsernameTC10 = "Username" + Utilities.getDateAndTime() + "@mail.com";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(newUsernameTC10, Constant.PASSWORD, confirmPassword, pid);
    }

    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("3. Enter information of the created account in Pre-condition");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(newUsernameTC10, Constant.PASSWORD, confirmPassword, pid);

        String actualRegErrorMsg = registerPage.getRegErrorMsg();
        String expectedRegErrorMsg = "This email address is already in use.";
        Assert.assertEquals(actualRegErrorMsg, expectedRegErrorMsg, "Error message is not displayed as expected");
    }
}
