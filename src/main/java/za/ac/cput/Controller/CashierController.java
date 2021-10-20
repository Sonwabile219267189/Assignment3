package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;
import za.ac.cput.Service.CashierService;
import za.ac.cput.Service.ICashierService;

@RestController
@RequestMapping("/cashier")
public class CashierController {

    private CashierService cashierService;

    public Cashier create (Cashier cashier){
        Cashier c = CashierFactory.createsCashier(cashier.getItemID(), cashier.getItem(), cashier.getQty(), cashier.getUnitPrice(), cashier.getDiscount(), cashier.getSubtotal(), cashier.getTotal());
        return cashierService.create(c);

    }

}