package za.ac.cput.Repository;

import za.ac.cput.Entity.Patient;

import java.util.Set;

public interface IPatientRepository extends IRepository<Patient,String>{

    boolean delete(String patID);

    Set<Patient> getAll();

}
