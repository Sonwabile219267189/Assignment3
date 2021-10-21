package za.ac.cput.Service;

import org.junit.Test;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {
    private static ReceiptService service = new ReceiptService();
    private static Receipt receipt = ReceiptFactory.createReceiptItem("zg8585");

    @Test
    void create(){
        Receipt created = service.create(receipt);
        assertEquals(created.getReceiptID(),receipt.getReceiptID());
        System.out.println("Receipt: "+created);
    }

    @Test
    void read(){
        Receipt read = service.read(receipt.getReceiptID());
        assertNotNull(read);
        System.out.println("Receipt: "+read);
    }

    @Test
    void update(){
        Receipt update =new Receipt.Builder().copy(receipt).setReceiptID("zg8567").build();
        System.out.println("Updated to: "+update);
    }

    @Test
    void delete (){
        boolean delete = service.delete(receipt.getReceiptID());
        assertTrue(delete);
        System.out.println("Deleted: "+ receipt.getReceiptID());

    }
}
