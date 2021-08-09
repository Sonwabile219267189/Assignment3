/*  Doctor.java
    Interface Repository for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 30 July 2021
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.Doctor;
import java.util.Set;

public interface IDoctorRepository extends IRepository<Doctor, String>
{
    public Set<Doctor> getAll();
}
