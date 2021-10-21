package za.ac.cput.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

class ReceiptRepositoryTest {

    private static IReceiptRepository repository = ReceiptRepository.getRepository();

    private static Receipt receipt = ReceiptFactory.createReceiptItem("zg8585");


    @Test
    void create() {
        Receipt created = repository.create(receipt);

        Assertions.assertEquals(created.getReceiptID(), receipt.getReceiptID() );

        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Receipt readReceipt = repository.read(receipt.getReceiptID());

        Assertions.assertEquals("zg8585", readReceipt.getReceiptID());
        System.out.println("Read: " + readReceipt.toString());
    }

    @Test
    void update() {
        System.out.println("Pre-update: "+ receipt.toString());

        Receipt newReceipt = new Receipt.Builder().copy(receipt).setReceiptID("zg8585").build();
        Receipt updatedReceipt = repository.update(newReceipt);

        Assertions.assertEquals("zg8585", updatedReceipt.getReceiptID());

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
        Assertions.assertNotNull(repository.getAll());

        System.out.println(repository.getAll());
    }
}
