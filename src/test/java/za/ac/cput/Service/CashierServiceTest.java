package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CashierServiceTest {
    private static CashierService service = new CashierService();
    private static Cashier cashier = CashierFactory.createsCashier("1003", "Vicks",2,65.00,0.00,65.00,65.00);

    @Test
    public void create(){
        Cashier created = service.create(cashier);
        assertEquals(created.getItemID(),cashier.getItemID());
        System.out.println("Create object : "+created);
    }

    @Test
    public void update(){
        Cashier update =new Cashier.Builder().copy(cashier).setItem("Cough Syrup").build();
        System.out.println("Updated to: "+update);
    }

    @Test
     public  void d_read(){
        Cashier c = service.read(cashier.getItemID());
        assertNotNull(c);
        System.out.println("Read : "+c);
    }

    @Test
    public  void b_delete (){
        boolean delete = service.delete(cashier.getItemID());
        assertTrue(delete);
        System.out.println("Deleted: "+cashier.getItemID());

    }
}
