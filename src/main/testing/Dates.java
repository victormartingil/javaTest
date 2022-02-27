package main.testing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {

    public String getCurrentDateWithFormat() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //¿yyyyMMddHHmmss?
        return sdf.format(cal.getTime());
    }
}
