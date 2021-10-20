/*  ICashierRepository.java
    This is a repository class for cashier entity.
    Author: Khanya Gibisela (217205135)
 */
package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Cashier;

import java.util.Set;

@Repository
public interface ICashierRepository extends JpaRepository<Cashier,String> {

}
