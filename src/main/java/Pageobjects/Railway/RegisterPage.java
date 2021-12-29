package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class RegisterPage {

    // Locators
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//input[@id='pid']");
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

    protected WebElement getlblRegConfirmMsg() {
        return Constant.WEBDRIVER.findElement(lblRegConfirmMsg);
    }

    protected WebElement getlblRegErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblRegErrorMsg);
    }

    protected WebElement getlblPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg);
    }

    protected WebElement getlblPIDErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPIDErrorMsg);
    }

    // Methods
    public void register(String username, String password, String confirmpassword, String pid) {
        this.getTxtEmail().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPID().sendKeys(pid);
        this.getBtnRegister().click();
    }

    public String getRegConfirmMsg() { return this.getlblRegConfirmMsg().getText(); }

    public String getRegErrorMsg() { return this.getlblRegErrorMsg().getText(); }

    public String getPasswordErrorMsg() { return this.getlblPasswordErrorMsg().getText(); }

    public String getPIDErrorMsg() { return this.getlblPIDErrorMsg().getText(); }

    public void ScrollRegPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", getBtnRegister());
    }
}