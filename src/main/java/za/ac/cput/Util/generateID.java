package za.ac.cput.Util;
/*  generateID.java
    Util for Secretary
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */

import java.util.UUID;

public class generateID {
    //this is method which will generate a random ID, when pulled across other classes
    public static String GenerateID()
    {
        return UUID.randomUUID().toString();
    }

}
