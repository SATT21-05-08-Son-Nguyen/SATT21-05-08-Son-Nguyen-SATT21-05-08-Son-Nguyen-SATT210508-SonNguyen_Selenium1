package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    // Locators
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabTimetable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    // Elements
    protected WebElement getTabLogin() { return Constant.WEBDRIVER.findElement(tabLogin); }
    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabContact() { return Constant.WEBDRIVER.findElement(tabContact); }
    protected WebElement getTabRegister() { return Constant.WEBDRIVER.findElement(tabRegister); }
    protected WebElement getTabChangePassword() { return Constant.WEBDRIVER.findElement(tabChangePassword); }
    protected WebElement getTabTimetable() { return Constant.WEBDRIVER.findElement(tabTimetable); }
    protected WebElement getTabMyTicket() { return Constant.WEBDRIVER.findElement(tabMyTicket); }
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    // Methods
    public String getWelcomeMessage() { return this.getLblWelcomeMessage().getText(); }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
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

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void gotoTimetablePage() {
        this.getTabTimetable().click();
    }

    public boolean findLogoutTab() {
        try {
            boolean isDisplayed = getTabLogout().isDisplayed();
            return isDisplayed;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
