package za.ac.cput.Repository;

import za.ac.cput.Entity.Receipt;

import java.util.Set;

public interface IReceiptRepository extends IRepository<Receipt, String>{
    Set<Receipt> getAll();
}
