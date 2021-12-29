package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // Locators
    private final By txtUsername = By.xpath("//*[@id='username']");
    private final By txtPassword = By.xpath("//*[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By ttlLoginPage = By.xpath("//h1['Login page']");

    // Elements
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    protected WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(lblLoginErrorMsg); }

    protected WebElement getTtlLoginPage() { return Constant.WEBDRIVER.findElement(ttlLoginPage); }

    // Methods
        public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        }

    public void loginMultipletimes(String username, String password) {
        for (int i = 0; i < 4; i++) {
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
        }
    }

    public String getLoginTitle() { return this.getTtlLoginPage().getText(); }

    public String getLoginErrorMsg() { return this.getLblLoginErrorMsg().getText(); }

    public boolean findErrorMsg() {
        try {
            getLblLoginErrorMsg();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
