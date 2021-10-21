package za.ac.cput.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Factory.PharmacyFactory;

class PharmacyRepositoryTest {

    private static IPharmacyRepository repository = PharmacyRepository.getRepository();

    private static Pharmacy pharmacy = PharmacyFactory.createPharmacyItem(2,50.0);


    @Test
    void create() {
        Assertions.assertNotNull(repository.create(pharmacy));

        System.out.println(repository.create(pharmacy));
    }

    @Test
    void read() {
        Pharmacy readPharmacy = repository.read(pharmacy.getMedicineID());

        Assertions.assertEquals("7777", readPharmacy.getMedicineID());
        System.out.println("Read: " + readPharmacy.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ pharmacy.toString());

        Pharmacy newPharmacy = new Pharmacy.Builder().copy(pharmacy).setMedicineID("8888").build();
        Pharmacy updatedPharmacy = repository.update(newPharmacy);

        Assertions.assertEquals("8888",updatedPharmacy.getMedicineID());

        System.out.println("Post-update: "+ updatedPharmacy.toString());
        System.out.println("Get all: ");
        getAll();
    }

    @Test
    void delete() {
        repository.delete(pharmacy.getMedicineID());

        System.out.println(repository.getAll());
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }
}
