package Pageobjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;

public class TimetablePage {

    // Locators
    String linkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']//preceding-sibling::th)+1]";

    // Elements

    // Methods
    public void gotoCheckPriceLink(String departStation, String arriveStation) {
        Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, departStation, arriveStation))).click();
    }

    public void scrollTimetablePage(String departStation, String arriveStation) {
        Utilities.scrollPage(Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, departStation, arriveStation))));
    }
}