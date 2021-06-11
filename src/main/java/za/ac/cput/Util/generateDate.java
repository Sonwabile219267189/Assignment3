package za.ac.cput.Util;

import java.time.LocalDate;

public class generateDate
{
    // This method checks the current date of the localhost and returns it when called upon by other classes
    public static LocalDate GenerateDate()
    {
        return java.time.LocalDate.now();
    }
}
