package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Factory.SecretaryFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class SecretaryRepositoryTest {

    private static ISecretaryRepository repository = SecretaryRepository.getRepository();

    private static Secretary secretary = SecretaryFactory.createSecretary("Xolani", "Ganta",12000.00);


    @Test
    void create() {
        assertNotNull(repository.create(secretary));

        System.out.println(repository.create(secretary));
    }

    @Test
    void read() {
        Secretary readSecretary = repository.read(secretary.getId());

        assertEquals("Xolani", readSecretary.getName());
        System.out.println("Read: " + readSecretary.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ secretary.toString());

        Secretary newSecretary = new Secretary.Builder().copy(secretary).setName("Damien").build();
        Secretary updatedSecretary = repository.update(newSecretary);

        assertEquals("Damien", updatedSecretary.getName());

        System.out.println("Post-update: "+ updatedSecretary.toString());
        System.out.println("Get all: ");
        getAll();
    }

    @Test
    void delete() {
        repository.delete(secretary.getId());

        System.out.println(repository.getAll());
    }

    @Test
    void getAll() {
        assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }
}