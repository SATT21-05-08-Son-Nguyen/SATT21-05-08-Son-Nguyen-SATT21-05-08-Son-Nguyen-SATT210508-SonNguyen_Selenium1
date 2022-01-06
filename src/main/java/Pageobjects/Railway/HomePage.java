package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    // Locators
    private final By lblHomePageTitle = By.xpath("//h1[@align='center']");

    // Elements
    protected WebElement getLblHomePageTitle() {
        return Constant.WEBDRIVER.findElement(lblHomePageTitle);
    }

    // Methods
    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public String getHomePageTitle() {
        return this.getLblHomePageTitle().getText();
    }
}
