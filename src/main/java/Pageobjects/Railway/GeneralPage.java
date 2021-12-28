package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    // Locators
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By tabBookticket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By tabChangepassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    // Elements
    protected WebElement getTabLogin() { return Constant.WEBDRIVER.findElement(tabLogin); }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookticket() {
        return Constant.WEBDRIVER.findElement(tabBookticket);
    }

    protected WebElement getTabContact() { return Constant.WEBDRIVER.findElement(tabContact); }

    protected WebElement getTabRegister() { return Constant.WEBDRIVER.findElement(tabRegister); }

    protected WebElement getTabChangepassword() { return Constant.WEBDRIVER.findElement(tabChangepassword); }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    // Methods
    public String getWelcomeMessage() { return this.getLblWelcomeMessage().getText(); }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoBookticketPage() {
        this.getTabBookticket().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoLogoutPage() {
        this.getTabLogout().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoChangepasswordPage() {
        this.getTabChangepassword().click();
    }
}
