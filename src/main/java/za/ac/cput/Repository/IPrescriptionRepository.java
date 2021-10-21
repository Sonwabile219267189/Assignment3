/**
 * PrescriptionRepository.java
 * Author: Sonwabile Gxoyiya
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.Prescription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription, String>{
    //public List<Prescription> getAll();

}
