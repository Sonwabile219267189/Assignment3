/*  Doctor.java
    Interface Doctor for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 30 July 2021
 */
package za.ac.cput.Service;

import za.ac.cput.Entity.Doctor;

import java.util.Set;

public interface IDoctorService extends IService<Doctor, String>
{

    public Set<Doctor> getAll();
    //public Doctor getDoctorGivenDescription(String description);
}
