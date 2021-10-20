package za.ac.cput.Repository;

import za.ac.cput.Entity.Prescription;
import java.util.List;

public interface IPrescriptionRepository extends IRepository<Prescription, String>{
    public List<Prescription> getAll();

}
