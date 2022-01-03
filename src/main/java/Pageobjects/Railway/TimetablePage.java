package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage {

    // Locators

    // Elements

    // Methods
    public void gotoCheckPriceLink(String DepartStation, String ArriveStation) {
        String checkPriceXPath = "//td[text()='" + DepartStation + "']/following-sibling::td[text()='" + ArriveStation + "']/../td[count(//th[text()='Check Price']//preceding-sibling::th)+1]";
        Constant.WEBDRIVER.findElement(By.xpath(checkPriceXPath)).click();
    }

}