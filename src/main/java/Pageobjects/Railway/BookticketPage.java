package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookticketPage {

    // Locators
    private final By ttlBookticketPage = By.xpath("//h1['Book ticket']");

    // Elements
        protected WebElement getTtlBookticketPage() { return Constant.WEBDRIVER.findElement(ttlBookticketPage); }

    // Methods
        public String getBookticketPageTitle() { return this.getTtlBookticketPage().getText(); }
}
