package Railway;

import Common.Constant;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{

    @Test (description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("3. Enter valid email address and leave other fields empty");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(Constant.RANDOMUSERNAME,"","","");

        String actualRegErrorMsg = registerPage.getRegErrorMsg();
        String expectedRegErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualRegErrorMsg, expectedRegErrorMsg, "Error message is not displayed as expected");

        String actualPasswordErrorMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordErrorMsg = "Invalid password length";
        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Error message is not displayed as expected");

        String actualPIDErrorMsg = registerPage.getPIDErrorMsg();
        String expectedPIDErrorMsg = "Invalid ID length";
        Assert.assertEquals(actualPIDErrorMsg, expectedPIDErrorMsg, "Error message is not displayed as expected");
    }
}
