/*  Doctor.java
    Factory for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Doctor;

public class DoctorFactory
{
    public static Doctor createDoctor(int doctorID,String firstName, String lastName,
                                      double salary)
    {
        Doctor doctor = new Doctor.Builder().setDoctorID(doctorID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setSalary(salary)
                .build();
        return doctor;
    }
}