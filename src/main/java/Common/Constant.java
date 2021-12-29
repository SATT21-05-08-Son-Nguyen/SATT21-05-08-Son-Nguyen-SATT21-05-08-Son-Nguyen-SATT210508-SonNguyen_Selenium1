package Common;

import org.openqa.selenium.WebDriver;
import java.util.Random;

public class Constant {
        private static int getRandomNumberInRange(int min, int max) {
                Random r = new Random();
                return r.nextInt((max - min) + 1) + min;
        }

        public static WebDriver WEBDRIVER;
        public static final String RAILWAY_URL = "http://www.railway.somee.com/Page/HomePage.cshtml";
        public static final String USERNAME = "aaa@mail.com";
        public static final String RANDOMUSERNAME = "Username" + getRandomNumberInRange(20,30) + "@mail.com";
        public static final String PASSWORD = "123456789";
        public static final String COMFIRMPASSWORD = "123456789";
        public static final String CPW_CURRENTPASSWORD = "123456789";
        public static final String CPW_NEWPASSWORD = "a123:\"/{}!@$\\";
        public static final String CPW_COMFIRMPASSWORD = "b456:\"/{}!@$\\";
        public static final String PID = "123456789";
        public static final String INVALIDUSERNAME = "a@com";
        public static final String INVALIDPASSWORD = "1234567";
}

