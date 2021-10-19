package za.ac.cput.Service;

import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Repository.PharmacyRepository;

public class PharmacyService implements IPharmacyService{

    private static IPharmacyService service = null;
    private PharmacyRepository repository;

    public PharmacyService() {
    }

    public PharmacyService(PharmacyRepository repository) {
        this.repository = repository;
    }

    public static IPharmacyService getService() {
        if (service==null)
            service = new PharmacyService();
        return service;
    }

    @Override
    public Pharmacy create(Pharmacy pharmacy) {
        return this.repository.create(pharmacy);
    }

    @Override
    public Pharmacy read(String ph) {
       return this.repository.read(ph);
    }

    @Override
    public Pharmacy update(Pharmacy) {
        return this.repository.update(pharmacy);
    }

    @Override
    public boolean delete(String ph) {
        this.repository.delete(ph);
        return true;
    }
}
