package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    // Locators

    // Elements
    private final By lblHomePage = By.xpath("//h1['Welcome to Safe Railway']");

    // Methods

    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
