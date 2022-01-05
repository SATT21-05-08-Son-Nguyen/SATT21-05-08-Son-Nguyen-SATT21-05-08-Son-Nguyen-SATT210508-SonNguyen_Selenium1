package Railway;

import Common.Constant;
import Pageobjects.Railway.ChangePasswordPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import Pageobjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{

    @Test (description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.scrollRegPage();
        String newUsername = Constant.RANDOM_USERNAME;
        registerPage.register(newUsername,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(newUsername, Constant.PASSWORD);

        System.out.println("3. Click on \"Change Password\" tab");
        homePage.gotoChangePasswordPage();

        System.out.println("4. Enter different information into \"New Password\" textbox and \"Confirm Password\" textbox.");
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.ScrollRegPage();
        changePasswordPage.changePassword(Constant.CPW_CURRENT_PASSWORD,Constant.CPW_NEW_PASSWORD,Constant.CPW_CONFIRM_PASSWORD);
        changePasswordPage.ScrollRegPage();

        String actualCPWErrorMsg = changePasswordPage.getChangePasswordErrorMsg();
        String expectedCPWErrorMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualCPWErrorMsg, expectedCPWErrorMsg, "Error message is not displayed as expected");

        String actualConfirmPWErrorMsg = changePasswordPage.getConfirmPasswordErrorMsg();
        String expectedConfirmPWErrorMsg = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualConfirmPWErrorMsg, expectedConfirmPWErrorMsg, "Error message is not displayed as expected");
    }
}