package za.ac.cput.Service;

import org.junit.Test;
import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Factory.PharmacyFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PharmacyServiceTest {
    private static PharmacyService service = new PharmacyService();
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacyItem(2,50.00);

    @Test
    void create(){
        Pharmacy created = service.create(pharmacy);
        assertEquals(created.getMedicineID(),pharmacy.getMedicineID());
        System.out.println("Pharmacy: "+created);
    }

    @Test
    void read(){
        Pharmacy read = service.read(pharmacy.getMedicineID());
        assertNotNull(read);
        System.out.println("Pharmacy: "+read);
    }

    @Test
    void update(){
        Pharmacy update =new Pharmacy.Builder().copy(pharmacy).setMedicineID("8567").build();
        System.out.println("Updated to: "+update);
    }

    @Test
    void delete (){
        boolean delete = service.delete(pharmacy.getMedicineID());
        assertTrue(delete);
        System.out.println("Deleted: "+pharmacy.getMedicineID());

    }
}
