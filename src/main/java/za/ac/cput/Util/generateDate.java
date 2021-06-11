package za.ac.cput.Util;
/*  generateDate.java
    Util for Secretary
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */

import java.time.LocalDate;

public class generateDate
{
    // This method checks the current date of the localhost and returns it when called upon by other classes
    public static LocalDate GenerateDate()
    {
        return java.time.LocalDate.now();
    }
}
