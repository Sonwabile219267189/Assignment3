package za.ac.cput.Service;

import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Service.IService;
import java.util.Set;

public interface IPharmacyService extends IService <Pharmacy,String>{

    public Set<Pharmacy> getAll();
}
