package za.ac.cput.Service;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.CashierFactory;
import za.ac.cput.Factory.PatientFactory;

import static org.junit.jupiter.api.Assertions.*;

class PatientServicesTest {
    private static PatientServices pateintS = new PatientServices();
    private static Patient patient = PatientFactory.build("Stefan",30,"Male");

    @Test
    void create() {
        Patient create = pateintS.create(patient);
        assertEquals(create.getPatientID(),patient.getPatientID());
        System.out.println("Made");
    }

    @Test
    void read() {
        Patient pat = pateintS.read(patient.getPatientID());
        assertNotNull(pat);
    }

    @Test
    void update() {
        Patient update =new Patient.Builder().clone(patient).firstName("Home").building();
        System.out.println(update.toString());
    }

    @Test
    void delete() {
        boolean del = pateintS.delete(patient.getPatientID());
        assertTrue(del);

    }

}