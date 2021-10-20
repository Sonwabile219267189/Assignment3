package za.ac.cput.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Patient;

import java.util.Set;

@Repository
public interface IPatientService  {
    public Set<Patient> getAll();
}
