package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Factory.PharmacyFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class PharmacyRepositoryTest {

    private static IPharmacyRepository repository = PharmacyRepository.getRepository();

    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy(50.00,7777,2);


    @Test
    void create() {
        assertNotNull(repository.create(pharmacy));

        System.out.println(repository.create(pharmacy));
    }

    @Test
    void read() {
        Pharmacy readPharmacy = repository.read(pharmacy.getMedicineID());

        assertEquals(7777, readPharmacy.getMedicineID());
        System.out.println("Read: " + readPharmacy.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ pharmacy.toString());

        Pharmacy newPharmacy = new Pharmacy.Builder().copy(pharmacy).setMedicineID(8888).build();
        Pharmacy updatedPharmacy = repository.update(newPharmacy);

        assertEquals(updatedPharmacy.getMedicineID());

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
        assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }
}
