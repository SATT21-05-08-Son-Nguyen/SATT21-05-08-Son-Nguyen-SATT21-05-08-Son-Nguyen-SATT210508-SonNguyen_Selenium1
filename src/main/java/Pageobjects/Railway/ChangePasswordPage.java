package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

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
    protected WebElement getLblChangePasswordErrorMsg() { return Constant.WEBDRIVER.findElement(lblChangePasswordErrorMsg); }
    protected WebElement getLblConfirmPasswordErrorMsg() { return Constant.WEBDRIVER.findElement(lblConfirmPasswordErrorMsg); }

    // Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }

    public String getChangePasswordErrorMsg() { return this.getLblChangePasswordErrorMsg().getText(); }

    public String getConfirmPasswordErrorMsg() { return this.getLblConfirmPasswordErrorMsg().getText(); }

    public void ScrollRegPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", getBtnChangePassword());
    }
}
