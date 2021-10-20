package za.ac.cput.Repository;


import za.ac.cput.Entity.Pharmacy;

import java.util.HashSet
import java.util.Set

public class PharmacyRepository implements IPharmacyRepository
{

    private static PharmacyRepository repository = null;
    private Set<Pharmacy> pharmacyDB = null;

    public PharmacyRepository(){
        this.pharmacyDB = new HashSet<>();
    }

    public static PharmacyRepository getRepository(){
        if (repository == null)
        {
            repository = new PharmacyRepository();
        }
        return repository;
    }

    @Override
    public Pharmacy create(Pharmacy pharmacy){
        boolean success = pharmacyDB.add(pharmacy);
        if(!success){
            return null;
        }
        return pharmacy;
    }

    @Override
    public Pharmacy read(String pharmacyId){
        for (Pharmacy pharmacy : this.pharmacyDB){
            if (pharmacy.getClass().equalsIgnoreCase(pharmacyId)){
                return pharmacy;
            }

        }
        return null;
    }

    @Override
    public Pharmacy update(Pharmacy ph) {
        delete(Pharmacy.getId());

        this.pharmacyDB.add(pharmacy);
        return pharmacy;
    }

    @Override
    public boolean delete(String ph) {
        Pharmacy deletePharmacy = read(ph);
        this.pharmacyDB.remove(deletePharmacy);
        return true;
    }

    @Override
    public Set<Pharmacy> getAll() {
        return pharmacyDB;
    }
}
