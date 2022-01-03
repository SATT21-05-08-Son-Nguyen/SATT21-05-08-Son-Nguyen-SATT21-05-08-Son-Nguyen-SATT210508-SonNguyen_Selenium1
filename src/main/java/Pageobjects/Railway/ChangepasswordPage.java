package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangepasswordPage {

    // Locators
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");
    private final By lblChangePasswordErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblConfirmPasswordErrorMsg = By.xpath("//label[@for='confirmPassword'][@class='validation-error']");

    // Elements
    protected WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    protected WebElement getlblChangePasswordErrorMsg() { return Constant.WEBDRIVER.findElement(lblChangePasswordErrorMsg); }

    protected WebElement getlblConfirmPasswordErrorMsg() { return Constant.WEBDRIVER.findElement(lblConfirmPasswordErrorMsg); }

    // Methods
    public void changepassword(String currentpassword, String newpassword, String confirmpassword) {
        this.getTxtCurrentPassword().sendKeys(currentpassword);
        this.getTxtNewPassword().sendKeys(newpassword);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getBtnChangePassword().click();
    }

    public String getChangePasswordErrorMsg() { return this.getlblChangePasswordErrorMsg().getText(); }

    public String getConfirmPasswordErrorMsg() { return this.getlblConfirmPasswordErrorMsg().getText(); }

    public void ScrollRegPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", getBtnChangePassword());
    }
}
