package za.ac.cput.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Factory.PharmacyFactory;
import za.ac.cput.Service.PharmacyService;

import java.util.Set;


@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping("/create")
    public Pharmacy create(Pharmacy pharmacy){
       Pharmacy newPharmacy = PharmacyFactory.createPharmacyItem(pharmacy.getQuantity(),pharmacy.getPrice());

        return pharmacyService.create(newPharmacy);


    }
    @PostMapping("/update")
    public Pharmacy update(@RequestBody Pharmacy pharmacy){
        return pharmacyService.update(pharmacy);
    }

    @GetMapping("/read/{medicineid}")
    public Pharmacy read(@PathVariable String medicineID){
        return pharmacyService.read(medicineID);
    }

    @PostMapping("/delete/{medicineid}")
    public Boolean Delete(@PathVariable String medicineID){
        return pharmacyService.delete(medicineID);
    }
    @GetMapping("/getAll")
    public Set<Pharmacy> getAll(){
        return pharmacyService.getAll();
    }
}
