package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilities {

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void main(String[] args) {
        System.out.println(getProjectPath());
    }

    public static long getDateAndTime() {
        Calendar calendar = Calendar.getInstance();
        long nowMill = calendar.getTimeInMillis();
        return nowMill;
    }

    public static String getFutureDate(int days) {
        SimpleDateFormat formDate = new SimpleDateFormat("M/d/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, days);
        String newDate = formDate.format(c.getTime());

        return newDate;
    }

    public static void scrollPage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitForElementDisplayed(String elementPath) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementPath)));
    }
}
