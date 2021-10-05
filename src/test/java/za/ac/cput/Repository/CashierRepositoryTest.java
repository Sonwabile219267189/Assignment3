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

   private static Cashier cashier = CashierFactory.createsCashier("14258","James","Zack",80.00);

    private static CashierRepository cashierRepository = CashierRepository.getRepository();


    @Test
    @Order(1)
    void TestCreate() {
       Cashier create = cashierRepository.create(cashier);
       assertEquals(create.getCashierID(),cashier.getCashierID());
        System.out.println("Create: " +create);


    }

    @Test
    @Order(2)
    void TestUpdate() {
        Cashier update =new Cashier.Builder().copy(cashier).setName("Adam").build();
       System.out.println(cashierRepository.update(update));
       assertNotNull(cashierRepository.update(update));

    }

    @Test
    @Order(3)
    void testRead() {
        Cashier c = cashierRepository.read(cashier.getCashierID());
        assertNotNull(c);
        System.out.println("Read: " +c);
    }

    @Test
    @Order(4)
    void testDelete() {
        Boolean success =cashierRepository.delete(cashier.getCashierID());
        assertTrue(success);
        System.out.println("Delete: " +success);
    }


}
