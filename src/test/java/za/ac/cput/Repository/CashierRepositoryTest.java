package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CashierRepositoryTest {

   private static Cashier cashier = CashierFactory.createsCashier("1001","Panado",1,95.00,0.00,95.00,95.00);

    private static CashierRepository cashierRepository = CashierRepository.getRepository();


    @Test
    @Order(1)
    void TestCreate() {
       Cashier create = cashierRepository.create(cashier);
       assertEquals(create.getItemID(),cashier.getItemID());
        System.out.println("Create: " +create);


    }

    @Test
    @Order(2)
    void TestUpdate() {
        Cashier update =new Cashier.Builder().copy(cashier).setItem("Pain Pills").build();
       System.out.println("Updated : "+cashierRepository.update(update));
       assertNotNull(cashierRepository.update(update));

    }

    @Test
    @Order(3)
    void testRead() {
        Cashier c = cashierRepository.read(cashier.getItemID());
        assertNotNull(c);
        System.out.println("Read: " +c);
    }

    @Test
    @Order(4)
    void testDelete() {
        Boolean success =cashierRepository.delete(cashier.getItemID());
        assertTrue(success);
        System.out.println("Delete: " +success);
    }


}
