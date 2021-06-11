package za.ac.cput.Factory;

//
//        PatientFactory.java
//        Entity for the PatientFactory
//        Author: Stefan Groenewald(219104891)
//        Date: 10 May 2021

import za.ac.cput.Entity.Patient;

import java.util.UUID;

public class PatientFactory {
    public static Patient build(String firstName, int age, String gender ){
        if (firstName.isEmpty() || !gender.equals("Male") && !gender.equals("Female") || age <=0 )
            return null;

        String id = UUID.randomUUID().toString();
        return new Patient.Builder().setID(id).setfirstName(firstName).age(age).gender(gender).building();

    }
}
