package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Repository.ICashierRepository;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CashierService implements ICashierService{

    private static ICashierService service = null;

    @Autowired
    private ICashierRepository repository;


    @Override
    public Cashier create(Cashier cashier) {
        return this.repository.save(cashier);
    }

    @Override
    public Cashier read(String itemID) {

        return this.repository.findById(itemID).orElse(null);
    }

    @Override
    public Cashier update(Cashier cashier) {
        if  (this.repository.existsById(cashier.getItemID()))
            return this.repository.save(cashier);
        return null;
    }

    @Override
    public boolean delete(String cashierID) {
        this.repository.deleteById(cashierID);
        if( this.repository.existsById(cashierID))
            return false;
        else
        return true;
    }

    public Set<Cashier> getAll(){
    return this.repository.findAll()
            .stream()
            .collect(Collectors.toSet());
    }
}