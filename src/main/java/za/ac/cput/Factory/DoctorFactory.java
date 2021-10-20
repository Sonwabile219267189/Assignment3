/*  Doctor.java
    Factory for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Util.generateID;

public class DoctorFactory
{

    public static Doctor createDoctor(String firstName, String lastName,
                                      double salary)
    {
        String doctorID = generateID.GenerateID();
        Doctor doctor = new Doctor.Builder().setDoctorID(doctorID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setSalary(salary)
                .build();
        return doctor;
    }
}