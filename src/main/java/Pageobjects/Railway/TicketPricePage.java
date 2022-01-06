package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {

    // Locators
    private final By lblTicketPricePage = By.xpath("//h1[@align='center']");
    private final By lblTableHeader = By.xpath("//th[@colspan]");
    private final By lblHS = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='HS']//preceding-sibling::td)+1]");
    private final By lblSS = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='SS']//preceding-sibling::td)+1]");
    private final By lblSSC = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='SSC']//preceding-sibling::td)+1]");
    private final By lblHB = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='HB']//preceding-sibling::td)+1]");
    private final By lblSB = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='SB']//preceding-sibling::td)+1]");
    private final By lblSBC = By.xpath("//*[normalize-space(text())='Price (VND)']/../td[count(//td[text()='SBC']//preceding-sibling::td)+1]");

    // Elements
    protected WebElement getLblTicketPricePage() {
        return Constant.WEBDRIVER.findElement(lblTicketPricePage);
    }

    protected WebElement getLblTableHeader() {
        return Constant.WEBDRIVER.findElement(lblTableHeader);
    }

    protected WebElement getLblHS() {
        return Constant.WEBDRIVER.findElement(lblHS);
    }

    protected WebElement getLblSS() {
        return Constant.WEBDRIVER.findElement(lblSS);
    }

    protected WebElement getLblSSC() {
        return Constant.WEBDRIVER.findElement(lblSSC);
    }

    protected WebElement getLblHB() {
        return Constant.WEBDRIVER.findElement(lblHB);
    }

    protected WebElement getLblSB() {
        return Constant.WEBDRIVER.findElement(lblSB);
    }

    protected WebElement getLblSBC() {
        return Constant.WEBDRIVER.findElement(lblSBC);
    }

    // Methods
    public String getTicketPricePageLabel() {
        return this.getLblTicketPricePage().getText();
    }

    public String getTableHeader() {
        return this.getLblTableHeader().getText();
    }

    public String getHSPrice() {
        return this.getLblHS().getText();
    }

    public String getSSPrice() {
        return this.getLblSS().getText();
    }

    public String getSSCPrice() {
        return this.getLblSSC().getText();
    }

    public String getHBPrice() {
        return this.getLblHB().getText();
    }

    public String getSBPrice() {
        return this.getLblSB().getText();
    }

    public String getSBCPrice() {
        return this.getLblSBC().getText();
    }
}