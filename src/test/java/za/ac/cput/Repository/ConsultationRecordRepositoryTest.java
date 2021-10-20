//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.Entity.ConsultationRecord;
//import za.ac.cput.Factory.ConsultationRecordFactory;
//
//
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.*;
//
//class ConsultationRecordRepositoryTest {
//
//    @Autowired
//    private  IConsultationRecordRepository repository ;
//
//    private static ConsultationRecord consultationRecord = ConsultationRecordFactory.createConsultationRecord("Toothache");
//
//    @Test
//    void getAll() {
//        System.out.println("All Consultation Records: " + repository.findAll().stream().collect(Collectors.toSet()));
//        assertEquals(1, repository.findAll().size());
//    }
//
//    @Test
//    void create() {
//        ConsultationRecord created = repository.save(consultationRecord);
//        assertEquals(consultationRecord.getConsultationId(), created.getConsultationId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void read() {
//        ConsultationRecord read = repository.findById(consultationRecord.getConsultationId()).orElse(null);
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update() {
//        ConsultationRecord updated = new ConsultationRecord.Builder()
//                .copy(consultationRecord).setDescription("Eye Check Up")
//                .build();
//        updated = repository.save(updated);
//        assertEquals("Eye Check up", repository.getOne(consultationRecord.getConsultationId()).getDescription());
//        System.out.println("Updated: " + updated);
//
//    }
//
//    @Test
//    void delete() {
//        repository.deleteById(consultationRecord.getConsultationId());
//        assertNull(repository.findById(consultationRecord.getConsultationId()));
//    }
//
//}