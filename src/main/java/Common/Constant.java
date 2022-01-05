package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
        public static WebDriver WEBDRIVER;
        public static final String RAILWAY_URL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        public static final String DATA_PATH = Utilities.getProjectPath() + "/src/main/java/DataObjects/data.json";
        public static final String USERNAME = "aaa@mail.com";
        public static final String RANDOM_USERNAME = "Username" + Utilities.getDateAndTime() + "@mail.com";
        public static final String PASSWORD = "123456789";
        public static final String CONFIRM_PASSWORD = "123456789";
        public static final String CPW_CURRENT_PASSWORD = "123456789";
        public static final String CPW_NEW_PASSWORD = "a123:\"/{}!@$\\";
        public static final String CPW_CONFIRM_PASSWORD = "b456:\"/{}!@$\\";
        public static final String PID = "123456789";
        public static final String INVALID_PASSWORD = "1234567";
        public static final String SEVEN_DAYS_AFTER_CURRENT_DAY = Utilities.getSevenDaysAfterCurrentDay();
        public static final int WAITING_TIME = 1000;
}