package Pageobjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {

    // Locators
    private final By lblBookTicketForm = By.xpath("//h1[@align='center']");
    private final By dropdownDate = By.xpath("//select[@name='Date']");
    private final By dropdownDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By dropdownArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By dropdownSeatType = By.xpath("//select[@name='SeatType']");
    private final By dropdownTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblConfirmMsg = By.xpath("//h1[@align='center']");
    private final By lblBookTicketPageErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblTicketAmountErrorMsg = By.xpath("//label[@class='validation-error']");
    private final By lblBookedDepartDate = By.xpath("//td[count(//th[text()='Depart Date']//preceding-sibling::th)+1]");
    private final By lblBookedDepartStation = By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1]");
    private final By lblBookedArriveStation = By.xpath("//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1]");
    private final By lblBookedSeatType = By.xpath("//td[count(//th[text()='Seat Type']//preceding-sibling::th)+1]");
    private final By lblBookedAmount = By.xpath("//td[count(//th[text()='Amount']//preceding-sibling::th)+1]");

    // Elements
    protected WebElement getLblBookTicketForm() {
        return Constant.WEBDRIVER.findElement(lblBookTicketForm);
    }

    protected WebElement getDropdownDate() {
        return Constant.WEBDRIVER.findElement(dropdownDate);
    }

    protected WebElement getDropdownDepartStation() {
        return Constant.WEBDRIVER.findElement(dropdownDepartStation);
    }

    protected WebElement getDropdownArriveStation() {
        return Constant.WEBDRIVER.findElement(dropdownArriveStation);
    }

    protected WebElement getDropdownSeatType() {
        return Constant.WEBDRIVER.findElement(dropdownSeatType);
    }

    protected WebElement getDropdownTicketAmount() {
        return Constant.WEBDRIVER.findElement(dropdownTicketAmount);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getLblConfirmMsg() {
        return Constant.WEBDRIVER.findElement(lblConfirmMsg);
    }

    protected WebElement getLblBookTicketPageErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblBookTicketPageErrorMsg);
    }

    protected WebElement getLblTicketAmountErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblTicketAmountErrorMsg);
    }

    protected WebElement getLblBookedDepartDate() {
        return Constant.WEBDRIVER.findElement(lblBookedDepartDate);
    }

    protected WebElement getLblBookedDepartStation() {
        return Constant.WEBDRIVER.findElement(lblBookedDepartStation);
    }

    protected WebElement getLblBookedArriveStation() {
        return Constant.WEBDRIVER.findElement(lblBookedArriveStation);
    }

    protected WebElement getLblBookedSeatType() {
        return Constant.WEBDRIVER.findElement(lblBookedSeatType);
    }

    protected WebElement getLblBookedAmount() {
        return Constant.WEBDRIVER.findElement(lblBookedAmount);
    }

    // Methods
    public boolean findBookTicketFormLabel() {
        try {
            getLblBookTicketForm();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void scrollBookTicketPage() {
        Utilities.scrollPage(getBtnBookTicket());
    }

    public void selectDropdown(String date, String departStation, String arriveStation, String seatType, int ticketAmount) {
        scrollBookTicketPage();

        Select selectDate = new Select(getDropdownDate());
        selectDate.selectByVisibleText(date);

        Select selectDepartStation = new Select(getDropdownDepartStation());
        selectDepartStation.selectByVisibleText(departStation);

        String arriveStationPath = "//select[@name='ArriveStation']/option[text()='%s']";
        Utilities.waitForElementDisplayed(String.format(arriveStationPath, arriveStation));

        Select selectArriveStation = new Select(getDropdownArriveStation());
        selectArriveStation.selectByVisibleText(arriveStation);

        Select selectSeatType = new Select(getDropdownSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Select selectTicketAmount = new Select(getDropdownTicketAmount());
        int selectedTicketAmount = ticketAmount - 1;
        selectTicketAmount.selectByIndex(selectedTicketAmount);

        this.getBtnBookTicket().click();
    }

    public String getConfirmMsg() {
        return this.getLblConfirmMsg().getText();
    }

    public String getBookedDepartDate() {
        return this.getLblBookedDepartDate().getText();
    }

    public String getBookedDepartStation() {
        return this.getLblBookedDepartStation().getText();
    }

    public String getBookedArriveStation() {
        return this.getLblBookedArriveStation().getText();
    }

    public String getBookedSeatType() {
        return this.getLblBookedSeatType().getText();
    }

    public String getBookedAmount() {
        return this.getLblBookedAmount().getText();
    }

    public String getBookTicketPageErrorMsg() {
        scrollBookTicketPage();
        return this.getLblBookTicketPageErrorMsg().getText();
    }

    public String getTicketAmountErrorMsg() {
        scrollBookTicketPage();
        return this.getLblTicketAmountErrorMsg().getText();
    }
}
