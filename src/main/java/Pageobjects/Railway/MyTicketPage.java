package Pageobjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {

    // Locators
    private final By btnCancel = By.xpath("//input[@value='Cancel']");

    // Elements
    protected WebElement getBtnCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    // Methods
    public void cancelTicket(String DepartStation, String ArriveStation, String SeatType, String DepartDate, String Amount) {
        scrollMyTicketPage();
        String cancelTicket = "//td[text()='" + DepartStation + "']/following-sibling::td[text()='" + ArriveStation + "']/following-sibling::td[text()='" + SeatType + "']/following-sibling::td[text()='" + DepartDate + "']/following-sibling::td[text()='" + Amount + "']/../td/input[@value='Cancel']";
        Constant.WEBDRIVER.findElement(By.xpath(cancelTicket)).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public void scrollMyTicketPage() {
        Utilities.scrollPage(getBtnCancel());
    }

    public boolean findCancelButton(String DepartStation, String ArriveStation, String SeatType, String DepartDate, String Amount) {
        String cancelTicket = "//td[text()='" + DepartStation + "']/following-sibling::td[text()='" + ArriveStation + "']/following-sibling::td[text()='" + SeatType + "']/following-sibling::td[text()='" + DepartDate + "']/following-sibling::td[text()='" + Amount + "']/../td/input[@value='Cancel']";

        try {
            boolean isDisplayed = Constant.WEBDRIVER.findElement(By.xpath(cancelTicket)).isDisplayed();
            return isDisplayed;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}