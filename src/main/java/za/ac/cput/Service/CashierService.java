package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.CashierRepository;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CashierService implements ICashierService{

    private static ICashierService service = null;
    private CashierRepository repository;

@Autowired
    public CashierService () {
        this.repository = CashierRepository.getRepository();
    }

    public static ICashierService getService() {
        if (service==null)
            service = new CashierService();
        return service;
    }

    @Override
    public Cashier create(Cashier cashier) {
        return this.repository.create(cashier);
    }

    @Override
    public Cashier read(String itemID) {

        return this.repository.read(itemID);
    }

    @Override
    public Cashier update(Cashier cashier) {
        return this.repository.update(cashier);
    }

    @Override
    public boolean delete(String c) {
        this.repository.delete(c);
        return true;
    }

    public Set<Cashier> getAll(){
    return this.repository.getAll();
    }
}