package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;

import za.ac.cput.Entity.ConsultationRecord;
import za.ac.cput.Factory.ConsultationRecordFactory;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class ConsultationRecordRepositoryTest {

    private static IConsultationRecordRepository repository = ConsultationRecordRepository.getRepository();

    private static ConsultationRecord consultationRecord = ConsultationRecordFactory.createConsultationRecord("Toothache");

    @Test
    void getAll() {
        assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }

    @Test
    void create() {
        assertNotNull(repository.create(consultationRecord));

        System.out.println(repository.create(consultationRecord));
    }

    @Test
    void read() {
        ConsultationRecord readConsultationRecord = repository.read(consultationRecord.getConsultationId());

        assertEquals("Toothache", readConsultationRecord.getDescription());
        System.out.println("Read: " + readConsultationRecord.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ consultationRecord .toString());

        ConsultationRecord  newConsultationRecord  = new ConsultationRecord .Builder().copy(consultationRecord ).setDescription("Eye check up").build();
        ConsultationRecord  updatedConsultationRecord  = repository.update(newConsultationRecord );

        assertEquals("eye check up", updatedConsultationRecord .getDescription());

        System.out.println("Post-update: "+ updatedConsultationRecord .toString());
        System.out.println("Get all: ");
        getAll();

    }

    @Test
    void delete() {
        repository.delete(consultationRecord.getConsultationId());

        System.out.println(repository.getAll());
    }

}