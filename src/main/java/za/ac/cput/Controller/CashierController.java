package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;
import za.ac.cput.Service.CashierService;
import za.ac.cput.Service.ICashierService;

import java.util.Set;

@RestController
@RequestMapping("/cashier")
public class CashierController {

    private CashierService cashierService;

    @PostMapping("/create")
    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    public Cashier create (@RequestBody Cashier cashier){
        Cashier c = CashierFactory.createsCashier(cashier.getItemID(), cashier.getItem(),cashier.getQty(), cashier.getUnitPrice(), cashier.getDiscount(), cashier.getSubtotal(), cashier.getTotal());
        return cashierService.create(c);
    }

    @GetMapping("/read")
    public Cashier read(@PathVariable Cashier cashier ){
        return cashierService.read(cashier.getItemID());
    }

    @PostMapping("/update")
    public Cashier update(@RequestBody Cashier cashier) {
        return cashier;
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Cashier cashier){
        if (cashierService.delete(cashier.getItemID()))
            return "The object that contains "+cashier.getItemID() +"is deleted";
        else
            return "Couldn't find the item";
    }

    @GetMapping("/getAll")
    public Set<Cashier> getAll(){
        return cashierService.getAll();
    }
}