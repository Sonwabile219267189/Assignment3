/*  ICashierRepository.java
    This is a repository class for cashier entity.
    Author: Khanya Gibisela (217205135)
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.Cashier;

import java.util.Set;

public interface ICashierRepository extends IRepository<Cashier,String>{

    Set<Cashier> getAll();

}
