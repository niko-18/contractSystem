package demo.utils;

import java.text.SimpleDateFormat;

public class DateHelper {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

    public static String convertDate(long date) {
        return dateFormat.format(date);
    }

    public static String convertDateTime(long date) {
        return dateTimeFormat.format(date);
    }
}
