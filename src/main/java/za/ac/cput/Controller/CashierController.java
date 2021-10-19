package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Entity.Cashier;

@RestController
@RequestMapping("/cashier")
public class CashierController {

    public Cashier create (Cashier cashier){
        return cashier;

    }

}