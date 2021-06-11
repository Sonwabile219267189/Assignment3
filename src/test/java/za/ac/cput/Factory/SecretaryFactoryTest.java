package za.ac.cput.Factory;
/*  SecretaryFactoryTest.java
    Test for SecretaryFactory
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Secretary;
import static org.junit.jupiter.api.Assertions.*;

class SecretaryFactoryTest {

    @Test
    @Timeout(6)
    // testing when there is not a null ,and the process should not exceed the specified timeout
    public void createSecretaryId() throws InterruptedException{
        Thread.sleep(5000);
        Secretary sec = SecretaryFactory.createSecretary("Xolani","Ganta",2900.00);
        System.out.println(sec.getId());
        assertNotNull(sec.getId());
    }
    @Test
    //testing to see what happens when a user doesn't input all the required information. *Test should fail
    public void createSecretaryIds(){
        Secretary sec = SecretaryFactory.createSecretary("","Ganta",2900.00);
        assertNull(sec.getId());
    }
    @Test
    //testing to see whether the name input equals the name on the system
    public void createSecretaryName(){
        Secretary sec = SecretaryFactory.createSecretary("Xolani","Ganta",2900.00);
        System.out.println("Name on the system is: "+sec.getName());
        assertEquals("Xolani",sec.getName());
    }
    @Test
    // testing to see if the surname is the same as the one in the system
    public void createSecretaryLastName(){
        Secretary sec = SecretaryFactory.createSecretary("Xolani","Ganta",2900.00);
        System.out.println("Surname on the system is: "+sec.getLastName());
        assertSame("Ganta",sec.getLastName());
    }

    @Disabled("CreateSecretarySalary disabled")
    @Test
    //We disabling the test
    public void createSecretarySalary(){
        Secretary sec = SecretaryFactory.createSecretary("Xolani","Ganta",2900.00);
        assertSame("2900.00",sec.getSalary());
    }
}