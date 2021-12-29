package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookticketPage {

    // Locators
    private final By lblBookticketForm = By.xpath("//h1['Book ticket']");

    // Elements
    protected WebElement getlblBookticketForm() { return Constant.WEBDRIVER.findElement(lblBookticketForm); }

    // Methods
    public String getBookticketFormLabel() { return this.getlblBookticketForm().getText(); }

    public boolean findBookticketFormLabel() {
        try {
            getlblBookticketForm();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
