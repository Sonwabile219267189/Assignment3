/*  PharmacyFactoryTest.java
    Entity for the PharmacyFactoryTest
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Pharmacy;

import static org.junit.jupiter.api.Assertions.*;

class PharmacyFactoryTest {

    @Timeout(5)
    @Test
    //test for valid input entered
    public void PharmacyItem(){
       Pharmacy ph = PharmacyFactory.createPharmacyItem(2,59.00);
        assertNull(ph.getMedicineID());
    }
    @Test
    //test for price equals system price
    public void PharmacyItemPrice(){
        Pharmacy ph = PharmacyFactory.createPharmacyItem(2,59.00);
        System.out.println("Price: "+ph.getPrice());
        assertEquals("Price: ",ph.getPrice());
    }

    @Disabled("Test Disabled")
    @Test
    //Disabling of Test
    public void PharmacyPrice(){
        Pharmacy ph = PharmacyFactory.createPharmacyItem(2, 59.00);
        assertSame(59,ph.getPrice());
    }
}
