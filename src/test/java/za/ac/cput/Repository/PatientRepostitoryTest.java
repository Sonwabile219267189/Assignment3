package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientRepostitoryTest {

    private static Patient pat = PatientFactory.build("James",80,"Male");
    private static PatientRepostitory patientRep = PatientRepostitory.getRepository();


    @Test
    @Order(1)
    void TestCreate() {
        Patient made = patientRep.create(pat);
        assertEquals(made.getPatientID(),pat.getPatientID());


    }

    @Test
    @Order(2)
    void TestUpdate() {
        Patient update =new Patient.Builder().clone(pat).setfirstName("earl").building();
        System.out.println(patientRep.update(update));
        assertNotNull(patientRep.update(update));

    }

    @Test
    @Order(3)
    void testRead() {
        Patient made = patientRep.read(pat.getPatientID());
        assertNotNull(made);
    }

    @Test
    @Order(4)
    void testDelete() {
        Boolean success =patientRep.delete(pat.getPatientID());
        assertTrue(success);
    }


}