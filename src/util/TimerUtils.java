package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class TimerUtils {

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

    private TimerUtils() {

    }

    public static Date getFutureTime(Date initialTime, long millisToAdd) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(initialTime.getTime() + millisToAdd);
        return cal.getTime();
    }

}
