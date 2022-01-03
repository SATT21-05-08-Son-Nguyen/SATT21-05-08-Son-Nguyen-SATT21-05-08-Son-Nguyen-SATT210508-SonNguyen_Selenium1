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

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.ScrollRegPage();

        System.out.println("3. Enter information of the created account in Pre-condition");
        registerPage.register(Constant.USERNAME,Constant.PASSWORD,Constant.COMFIRMPASSWORD,Constant.PID);
        registerPage.ScrollRegPage();

        String actualRegErrorMsg = registerPage.getRegErrorMsg();
        String expectedRegErrorMsg = "This email address is already in use.";
        Assert.assertEquals(actualRegErrorMsg, expectedRegErrorMsg, "Error message is not displayed as expected");
    }
}
