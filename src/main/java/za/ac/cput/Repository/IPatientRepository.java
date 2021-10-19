package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Patient;

import java.util.Set;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,String> {




}
