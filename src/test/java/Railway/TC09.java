package Railway;

import Common.Constant;
import Pageobjects.Railway.ChangepasswordPage;
import Pageobjects.Railway.HomePage;
import Pageobjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{

    @Test (description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09() {
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Change Password\" tab");
        homePage.gotoChangepasswordPage();

        System.out.println("4. Enter valid information into \"Current Password\" textbox but enter \"a123:\"/{}!@$\\\" into \"New Password\" textbox and \"b456:\"/{}!@$\\\" into \"Confirm Password\" textbox.");
        ChangepasswordPage changepasswordPage = new ChangepasswordPage();
        changepasswordPage.ScrollRegPage();
        changepasswordPage.changepassword(Constant.CPW_CURRENTPASSWORD,Constant.CPW_NEWPASSWORD,Constant.CPW_COMFIRMPASSWORD);
        changepasswordPage.ScrollRegPage();

        String actualCPWErrorMsg = changepasswordPage.getChangePasswordErrorMsg();
        String expectedCPWErrorMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualCPWErrorMsg, expectedCPWErrorMsg, "Error message is not displayed as expected");

        String actualConfirmPWErrorMsg = changepasswordPage.getConfirmPasswordErrorMsg();
        String expectedConfirmPWErrorMsg = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualConfirmPWErrorMsg, expectedConfirmPWErrorMsg, "Error message is not displayed as expected");
    }
}