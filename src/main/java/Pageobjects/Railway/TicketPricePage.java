package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TicketPricePage {

    // Locators
    private final By lblTicketPricePage = By.xpath("//h1[@align='center']");
    private final By txtTableHeader = By.xpath("//th[@colspan]");
    private final By txtHS = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='HS']//preceding-sibling::td)+1]");
    private final By txtSS = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='SS']//preceding-sibling::td)+1]");
    private final By txtSSC = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='SSC']//preceding-sibling::td)+1]");
    private final By txtHB = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='HB']//preceding-sibling::td)+1]");
    private final By txtSB = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='SB']//preceding-sibling::td)+1]");
    private final By txtSBC = By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[3]/th/../td[count(//td[text()='SBC']//preceding-sibling::td)+1]");

    // Elements
    protected WebElement getLblTicketPricePage() {
        return Constant.WEBDRIVER.findElement(lblTicketPricePage);
    }
    protected WebElement getTxtTableHeader() {
        return Constant.WEBDRIVER.findElement(txtTableHeader);
    }
    protected WebElement getTxtHS() {
        return Constant.WEBDRIVER.findElement(txtHS);
    }
    protected WebElement getTxtSS() {
        return Constant.WEBDRIVER.findElement(txtSS);
    }
    protected WebElement getTxtSSC() {
        return Constant.WEBDRIVER.findElement(txtSSC);
    }
    protected WebElement getTxtHB() {
        return Constant.WEBDRIVER.findElement(txtHB);
    }
    protected WebElement getTxtSB() {
        return Constant.WEBDRIVER.findElement(txtSB);
    }
    protected WebElement getTxtSBC() {
        return Constant.WEBDRIVER.findElement(txtSBC);
    }

    // Methods
    public String getTicketPricePageLabel() { return this.getLblTicketPricePage().getText(); }
    public String getTableHeader() { return this.getTxtTableHeader().getText(); }
    public String getHSPrice() { return this.getTxtHS().getText(); }
    public String getSSPrice() { return this.getTxtSS().getText(); }
    public String getSSCPrice() { return this.getTxtSSC().getText(); }
    public String getHBPrice() { return this.getTxtHB().getText(); }
    public String getSBPrice() { return this.getTxtSB().getText(); }
    public String getSBCPrice() { return this.getTxtSBC().getText(); }
}