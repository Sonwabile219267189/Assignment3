/*  ReceiptFactoryTest.java
    Entity for the ReceiptFactoryTest
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Receipt;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptFactoryTest {
    @Timeout(5)
    @Test
    //test for valid input
    public void ReceiptInput(){
        Receipt rcp = ReceiptFactory.createReceiptItem();
        assertNull(rcp.getReceiptID());
    }
    @Test
    //test for receiptID against system receiptID
    public void ReceiptEquality(){
        Receipt rcp = ReceiptFactory.createReceiptItem();
        System.out.println("Receipt ID: "+rcp.getReceiptID());
        assertEquals("Receipt ID: ",rcp.getReceiptID());
    }

    @Disabled("Test Disabled")
    @Test
    //Disabling of Test
    public void ReceiptDisable(){
        Receipt rcp = ReceiptFactory.createReceiptItem();
        assertSame("Receipt ID: ",rcp.getReceiptID());
    }

}
