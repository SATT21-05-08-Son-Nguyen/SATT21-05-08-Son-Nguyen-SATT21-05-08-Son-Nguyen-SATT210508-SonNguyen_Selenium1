package Pageobjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    // Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@title='Register']");
    private final By lblRegConfirmMsg = By.xpath("//p['Registration Confirmed! You can now log in to the site.']");
    private final By lblRegErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblPasswordErrorMsg = By.xpath("//label[@for='password'][@class='validation-error']");
    private final By lblPIDErrorMsg = By.xpath("//label[@for='pid'][@class='validation-error']");

    // Elements
    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }
    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    protected WebElement getLblRegConfirmMsg() { return Constant.WEBDRIVER.findElement(lblRegConfirmMsg); }
    protected WebElement getLblRegErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblRegErrorMsg);
    }
    protected WebElement getLblPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg);
    }
    protected WebElement getLblPIDErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPIDErrorMsg);
    }

    // Methods
    public void register(String username, String Password, String ConfirmPassword, String PID) {
        this.getTxtEmail().sendKeys(username);
        this.getTxtPassword().sendKeys(Password);
        this.getTxtConfirmPassword().sendKeys(ConfirmPassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();
    }

    public String getRegConfirmMsg() { return this.getLblRegConfirmMsg().getText(); }

    public String getRegErrorMsg() { return this.getLblRegErrorMsg().getText(); }

    public String getPasswordErrorMsg() { return this.getLblPasswordErrorMsg().getText(); }

    public String getPIDErrorMsg() { return this.getLblPIDErrorMsg().getText(); }

    public void scrollRegPage() {
        Utilities.scrollPage(getBtnRegister());
    }
}