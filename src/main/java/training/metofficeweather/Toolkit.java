package training.metofficeweather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Toolkit {
    public static String greenText(String text) {
        return "\u001b[32m" + text + "\u001b[0m";
    }
    public static String redText(String text) {
        return "\u001b[31m" + text + "\u001b[0m";
    }
    public static String showDateOnly(Date date) {
        DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
