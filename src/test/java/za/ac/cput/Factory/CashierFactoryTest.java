/*  CashierFactory.java
    This is a factoryTest class of a cashier.
    Author: Khanya Gibisela (217205135)
    Date: 11 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.jupiter.api.Assertions.*;

class CashierFactoryTest {
    private CashierFactory cashier,cashier1,cashier2;

    @BeforeEach
    void setUp() {
        cashier = cashier1;
        cashier2 = cashier;
    }

    @Test
    public void createCashier() {
        Cashier cashier = CashierFactory.createsCashier("12345","Felicia", "Jacobs",950.000);
        System.out.println(cashier);
    }

    @Test
    public void testEquality(){
        Assertions.assertEquals(cashier1,cashier2);

    }

    @Test
    public void TestIdentity(){

        Assertions.assertSame(cashier,cashier2);
    }


    @Test
    public void testTimeout() throws InterruptedException {
        int timeout = 10;
        TimeUnit.SECONDS.sleep(timeout);
        System.out.println(" Setting the Timeout");
    }
    @Test
    @Disabled
    public void testDisable(){
        org.junit.jupiter.api.Assertions.fail("Test disabled");
    }

}