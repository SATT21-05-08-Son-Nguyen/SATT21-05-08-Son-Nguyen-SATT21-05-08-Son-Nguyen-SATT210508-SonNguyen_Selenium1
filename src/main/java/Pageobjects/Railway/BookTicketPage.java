package Pageobjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {

    // Locators
    private final By lblBookTicketForm = By.xpath("//h1['Book ticket']");
    private final By dropdownDate = By.xpath("//select[@name='Date']");
    private final By dropdownDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By dropdownArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By dropdownSeatType = By.xpath("//select[@name='SeatType']");
    private final By dropdownTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblConfirmMsg = By.xpath("//h1[@align='center']");
    private final By lblBookTicketPageErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblTicketAmountErrorMsg = By.xpath("//label[@class='validation-error']");
    private final By txtDepartDateAfterBooking = By.xpath("//td[count(//th[text()='Depart Date']//preceding-sibling::th)+1]");
    private final By txtDepartStationAfterBooking = By.xpath("//td[count(//th[text()='Depart Station']//preceding-sibling::th)+1]");
    private final By txtArriveStationAfterBooking = By.xpath("//td[count(//th[text()='Arrive Station']//preceding-sibling::th)+1]");
    private final By txtSeatTypeAfterBooking = By.xpath("//td[count(//th[text()='Seat Type']//preceding-sibling::th)+1]");
    private final By txtAmountAfterBooking = By.xpath("//td[count(//th[text()='Amount']//preceding-sibling::th)+1]");

    // Elements
    protected WebElement getLblBookTicketForm() { return Constant.WEBDRIVER.findElement(lblBookTicketForm); }
    protected WebElement getDropdownDate() { return Constant.WEBDRIVER.findElement(dropdownDate); }
    protected WebElement getDropdownDepartStation() { return Constant.WEBDRIVER.findElement(dropdownDepartStation); }
    protected WebElement getDropdownArriveStation() { return Constant.WEBDRIVER.findElement(dropdownArriveStation); }
    protected WebElement getDropdownSeatType() { return Constant.WEBDRIVER.findElement(dropdownSeatType); }
    protected WebElement getDropdownTicketAmount() { return Constant.WEBDRIVER.findElement(dropdownTicketAmount); }
    protected WebElement getBtnBookTicket() { return Constant.WEBDRIVER.findElement(btnBookTicket); }
    protected WebElement getLblConfirmMsg() { return Constant.WEBDRIVER.findElement(lblConfirmMsg); }
    protected WebElement getLblBookTicketPageErrorMsg() { return Constant.WEBDRIVER.findElement(lblBookTicketPageErrorMsg); }
    protected WebElement getLblTicketAmountErrorMsg() { return Constant.WEBDRIVER.findElement(lblTicketAmountErrorMsg); }
    protected WebElement getTxtDepartDateAfterBooking() { return Constant.WEBDRIVER.findElement(txtDepartDateAfterBooking); }
    protected WebElement getTxtDepartStationAfterBooking() { return Constant.WEBDRIVER.findElement(txtDepartStationAfterBooking); }
    protected WebElement getTxtArriveStationAfterBooking() { return Constant.WEBDRIVER.findElement(txtArriveStationAfterBooking); }
    protected WebElement getTxtSeatTypeAfterBooking() { return Constant.WEBDRIVER.findElement(txtSeatTypeAfterBooking); }
    protected WebElement getTxtAmountAfterBooking() { return Constant.WEBDRIVER.findElement(txtAmountAfterBooking); }

    // Methods
    public String getBookTicketFormLabel() { return this.getLblBookTicketForm().getText(); }

    public boolean findBookTicketFormLabel() {
        try {
            getLblBookTicketForm();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void scrollBookTicketPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", getBtnBookTicket());
    }

    public void selectDropdown(String Date, String DepartStation, String ArriveStation, String SeatType, String TicketAmount) throws InterruptedException {
        Select selectDate = new Select(getDropdownDate());
        selectDate.selectByVisibleText(Date);

        Select selectDepartStation = new Select(getDropdownDepartStation());
        selectDepartStation.selectByVisibleText(DepartStation);
        Thread.sleep(Constant.WAITINGTIME);

        Select selectArriveStation = new Select(getDropdownArriveStation());
        selectArriveStation.selectByVisibleText(ArriveStation);

        Select selectSeatType = new Select(getDropdownSeatType());
        selectSeatType.selectByVisibleText(SeatType);

        Select selectTicketAmount = new Select(getDropdownTicketAmount());
        selectTicketAmount.selectByVisibleText(TicketAmount);

        this.getBtnBookTicket().click();
    }

    public String getConfirmMsg() { return this.getLblConfirmMsg().getText(); }

    public String getDepartDateAfterBooking() { return this.getTxtDepartDateAfterBooking().getText(); }

    public String getDepartStationAfterBooking() { return this.getTxtDepartStationAfterBooking().getText(); }

    public String getArriveStationAfterBooking() { return this.getTxtArriveStationAfterBooking().getText(); }

    public String getSeatTypeAfterBooking() { return this.getTxtSeatTypeAfterBooking().getText(); }

    public String getAmountAfterBooking() { return this.getTxtAmountAfterBooking().getText(); }

    public String getBookTicketPageErrorMsg() { return this.getLblBookTicketPageErrorMsg().getText(); }

    public String getTicketAmountErrorMsg() { return this.getLblTicketAmountErrorMsg().getText(); }
}
