package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
    public static final String DATA_PATH = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
    public static final String USERNAME = "aaa@mail.com";
    public static final String PASSWORD = "123456789";
}