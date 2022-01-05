package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilities {

    public static String getProjectPath(){ return System.getProperty("user.dir"); }

    public static void main(String[] args){
        System.out.println(getProjectPath());
    }

    public static long getDateAndTime() {
        Calendar calendar = Calendar.getInstance();
        long nowMill = calendar.getTimeInMillis();
        return nowMill;
    }

    public static String getSevenDaysAfterCurrentDay() {
        SimpleDateFormat formDate = new SimpleDateFormat("M/d/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 7);
        String newDate = formDate.format(c.getTime());

        return newDate;
    }

    public static void scrollPage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
