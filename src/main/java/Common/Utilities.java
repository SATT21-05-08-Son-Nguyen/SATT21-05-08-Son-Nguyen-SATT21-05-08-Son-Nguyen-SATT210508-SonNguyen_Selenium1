package Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static String getprojectPath(){
        return System.getProperty("user.dir");
    }

    public static void main(String[] args){
        System.out.println(getprojectPath());
    }

    public static void getDateTime(String[] args) {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        // Print the Date
        System.out.println("Current date and time is " + date1);
    }
}
