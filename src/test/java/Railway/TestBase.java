package Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getprojectPath()
                + "\\src\\main\\java\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }
}
