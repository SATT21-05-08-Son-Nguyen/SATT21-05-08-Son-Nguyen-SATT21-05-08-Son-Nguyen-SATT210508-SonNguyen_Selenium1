package Railway;

import Common.Constant;
import Common.Utilities;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    String confirmPassword = Constant.PASSWORD;
    String pid = "123456789";
    String newUsernameTC07 = "Username" + Utilities.getDateAndTime() + "@mail.com";

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(newUsernameTC07, Constant.PASSWORD, confirmPassword, pid);

        String actualMsg = registerPage.getRegConfirmMsg();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Confirm message is not displayed as expected");
    }
}
