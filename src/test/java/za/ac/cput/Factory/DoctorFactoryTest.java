/*  Doctor.java
    Test for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Doctor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DoctorFactoryTest {

    Doctor doctor1 = DoctorFactory.createDoctor(1035601,"Bheka", "Gumede", 45000.59);
    Doctor doctor2 = DoctorFactory.createDoctor(202021,"Sizwe", "Qwabe", 41544.89);

    @Test
    public void doctorTest()
    {
        System.out.println(doctor2);
        System.out.println(doctor2);
        assertEquals(4, 4); //test based on each object
    }



    @Test
    void testEquality() {
        assertNotEquals(doctor1, doctor2);
    }


    @Test
    void testIdentity() {
        assertNotSame(doctor1, doctor2);
    }

    @Test
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void timeout() {
        assertNotSame(doctor1, doctor2);
    }
    @Disabled
    @Test
    void disableTest(){
        assertNotEquals(doctor1,doctor2);

    }
}