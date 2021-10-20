//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.Entity.Secretary;
//import za.ac.cput.Factory.SecretaryFactory;
//
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SecretaryRepositoryTest {
//
//    private  ISecretaryRepository repository;
//
//    private static Secretary secretary = SecretaryFactory.createSecretary("Xolani", "Ganta",12000.00);
//
//
//    @Test
//    void create() {
//        Secretary created = repository.save(secretary);
//        assertEquals(secretary.getId(), created.getId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void read() {
//        Secretary read = repository.findById(secretary.getId()).orElse(null);
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update() {
//        Secretary updated = new Secretary.Builder()
//                .copy(secretary).setName("Rebecca")
//                .build();
//        updated = repository.save(updated);
//        assertEquals("Rebecca", repository.getOne(secretary.getId()).getName());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void delete() {
//        repository.deleteById(secretary.getId());
//        assertNull(repository.findById(secretary.getId()));
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("All Secretaries: " + repository.findAll().stream().collect(Collectors.toSet()));
//        assertEquals(1, repository.findAll().size());
//    }
//}