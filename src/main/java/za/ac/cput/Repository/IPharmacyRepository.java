package za.ac.cput.Repository;

import za.ac.cput.Entity.Pharmacy;

import java.util.Set;

public interface IPharmacyRepository extends IRepository<Pharmacy, String> {

    Set<Pharmacy> getAll();
}
