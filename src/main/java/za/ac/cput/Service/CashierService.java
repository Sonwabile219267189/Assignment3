package za.ac.cput.Service;

import za.ac.cput.Entity.Cashier;
import za.ac.cput.Repository.CashierRepository;

public class CashierService implements ICashierService{

    private static ICashierService service = null;
    private CashierRepository repository;

    public CashierService() {
    }

    public CashierService(CashierRepository repository) {
        this.repository = repository;
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
    public Cashier read(String c) {
       return this.repository.read(c);
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
}
