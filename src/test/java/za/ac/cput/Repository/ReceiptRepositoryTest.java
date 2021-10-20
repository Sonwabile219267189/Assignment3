package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptRepositoryTest {

    private static IReceiptRepository repository = ReceiptRepository.getRepository();

    private static Receipt receipt = ReceiptFactory.createReceipt(7575);


    @Test
    void create() {
        assertNotNull(repository.create(reciept));

        System.out.println(repository.create(reciept));
    }

    @Test
    void read() {
        Receipt readReceipt = repository.read(receipt.getReceiptID());

        assertEquals(7575, readReceipt.getReceiptID());
        System.out.println("Read: " + readReceipt.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ receipt.toString());

        Receipt newReceipt = new Receipt.Builder().copy(receipt).setReceiptID(8585).build();
        Receipt updatedReceipt = repository.update(newReceipt);

        assertEquals(updatedReceipt.getReceiptID());

        System.out.println("Post-update: "+ updatedReceipt.toString());
        System.out.println("Get all: ");
        getAll();
    }

    @Test
    void delete() {
        repository.delete(receipt.getReceiptID());

        System.out.println(repository.getAll());
    }

    @Test
    void getAll() {
        assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }
}
