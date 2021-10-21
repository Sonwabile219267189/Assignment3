package za.ac.cput.Service;
import za.ac.cput.Entity.Receipt;

import java.util.Set;

public interface IReceiptService extends IService <Receipt,String>{
    public Set<Receipt> getAll();
}
