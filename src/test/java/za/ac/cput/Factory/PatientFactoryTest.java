package za.ac.cput.Factory;

//
//        PatientFactory.java
//        Entity for the PatientFactory
//        Author: Stefan Groenewald(219104891)
//        Date: 10 June 2021

import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientFactoryTest {
    @Timeout(10)
    @Test
    void Excisit() {
        Patient p = PatientFactory.build("james",60,"Male");

        assertNotNull(p);
        }

    @Test
    @Ignore
    void testCopy() {
        Patient p = PatientFactory.build("james",60,"Male");
        p = new Patient.Builder().clone(p).firstName("Earl").gender("Female").building();


        Patient pCopy = PatientFactory.build("Earl",60,"Female");

        assertEquals(p,pCopy);


    }
}