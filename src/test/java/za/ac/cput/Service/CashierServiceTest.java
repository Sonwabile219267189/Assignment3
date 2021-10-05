package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;


import static org.junit.jupiter.api.Assertions.*;

public class CashierServiceTest {
    private static CashierService service = new CashierService();
    private static Cashier cashier = CashierFactory.createsCashier("100001","Adam","Wick",15000.00);

    @Test
    void create(){
        Cashier created = service.create(cashier);
        assertEquals(created.getCashierID(),cashier.getCashierID());
        System.out.println("Cashier: "+created);
    }

    @Test
    void read(){
        Cashier read = service.read(cashier.getCashierID());
        assertNotNull(read);
        System.out.println("Cashier: "+read);
    }

    @Test
    void update(){
        Cashier update =new Cashier.Builder().copy(cashier).setName("Smith").build();
        System.out.println("Updated to: "+update);
    }

    @Test
    void delete (){
        boolean delete = service.delete(cashier.getCashierID());
        assertTrue(delete);
        System.out.println("Deleted: "+cashier.getCashierID()+ " ");

    }
}
