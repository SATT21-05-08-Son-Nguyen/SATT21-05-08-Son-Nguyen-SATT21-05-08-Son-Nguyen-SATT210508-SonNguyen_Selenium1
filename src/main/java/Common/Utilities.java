package Common;

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
}
