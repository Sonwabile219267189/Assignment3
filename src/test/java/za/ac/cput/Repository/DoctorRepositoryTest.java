
/*  Doctor.java
    Repository Test for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 30 July 2021
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DoctorRepositoryTest {

    private static DoctorRepository repository = DoctorRepository.getRepository();
    private static Doctor doctor = DoctorFactory.createDoctor("Dr Bheka", "Gumede", 99000.00);
    @Test
    void a_create()
    {
        Doctor created = repository.create(doctor);
        assertEquals(created.getFirstName(), doctor.getFirstName());
        System.out.println("Create: " + created);
    }

  @Test
    void b_read()
   {
       Doctor read = repository.read(doctor.getDoctorID());
       assertNotNull(read);
       System.out.println("Read: " + read);
    }

   @Test
    void update()
   {
       Doctor newDoctor = doctor;
       newDoctor.setLastName("Mkhize");
       repository.update(newDoctor);
       assertEquals("Mkhize", repository.read(doctor.getDoctorID()).getLastName());
       System.out.println("Updated " + repository.read(doctor.getDoctorID()));

    }

    @Test
    void delete()
    {
      boolean deleted = repository.delete(doctor.getDoctorID());
      assertTrue(deleted);
    }

    @Test
    void getAll()
    {
        assertEquals(0, repository.getAll().size());
    }

}