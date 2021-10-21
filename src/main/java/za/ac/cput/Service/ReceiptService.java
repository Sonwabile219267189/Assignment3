package za.ac.cput.Service;

import za.ac.cput.Entity.Receipt;
import za.ac.cput.Repository.ReceiptRepository;

import java.util.Set;

public class ReceiptService implements IReceiptService{

    private static IReceiptService service = null;
    private ReceiptRepository repository;

    public ReceiptService() {
    }

    public ReceiptService(ReceiptRepository repository) {
        this.repository = repository;
    }

    public static IReceiptService getService() {
        if (service==null)
            service = new ReceiptService();
        return service;
    }

    @Override
    public Receipt create(Receipt receipt) {
        return this.repository.create(receipt);
    }

    @Override
    public Receipt read(String r) {
       return this.repository.read(r);
    }

    @Override
    public Receipt update(Receipt receipt) {
        return this.repository.update(receipt);
    }

    @Override
    public boolean delete(String r) {
        this.repository.delete(r);
        return true;
    }

    @Override
    public Set<Receipt> getAll(){return this.repository.getAll();}
}
