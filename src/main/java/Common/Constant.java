package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
        public static WebDriver WEBDRIVER;
        public static final String RAILWAY_URL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        public static final String USERNAME = "aaa@mail.com";
        public static final String RANDOMUSERNAME = "Username" + Utilities.getDateAndTime() + "@mail.com";
        public static final String PASSWORD = "123456789";
        public static final String COMFIRMPASSWORD = "123456789";
        public static final String CPW_CURRENTPASSWORD = "123456789";
        public static final String CPW_NEWPASSWORD = "a123:\"/{}!@$\\";
        public static final String CPW_COMFIRMPASSWORD = "b456:\"/{}!@$\\";
        public static final String PID = "123456789";
        public static final String INVALIDUSERNAME = "a@com";
        public static final String INVALIDPASSWORD = "1234567";
        public static final String HOMEPAGETITLE = "Welcome to Safe Railway";
        public static final String LOGINPAGETITLE = "Login Page";
        public static final String BOOKTICKETPAGETITLE = "Book ticket";
        public static final int WAITINGTIME = 500;
}

