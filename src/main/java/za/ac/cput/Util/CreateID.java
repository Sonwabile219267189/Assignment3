package za.ac.cput.Util;

/**
 * createID.java
 * Author: Sonwabile Gxoyiya
 * Date: 30 September 2021
 */

import java.util.UUID;

public class CreateID {

    public static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
