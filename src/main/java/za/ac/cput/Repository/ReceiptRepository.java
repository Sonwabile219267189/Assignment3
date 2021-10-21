package za.ac.cput.Repository;

import za.ac.cput.Entity.Receipt;

import java.util.HashSet;
import java.util.Set;

public class ReceiptRepository implements IReceiptRepository {

    private static ReceiptRepository repository = null;

    private Set<Receipt> receiptDB = null;

    public ReceiptRepository(){
        this.receiptDB = new HashSet<>();
    }

    public static ReceiptRepository getRepository(){
        if(repository == null){
            repository = new ReceiptRepository();
        }
        return repository;
    }

    @Override
    public Set<Receipt> getAll() {
        return receiptDB;
    }

    @Override
    public Receipt create(Receipt receipt) {
        this.receiptDB.add(receipt);
        return receipt;
    }

    @Override
    public Receipt read(String r) {
        for(Receipt receipt : this.receiptDB){

            if(receipt.getReceiptID().equalsIgnoreCase(r)){
                return receipt;
            }

        }
        return null;
    }

    @Override
    public Receipt update(Receipt receipt) {
        delete(receipt.getReceiptID());

        this.receiptDB.add(receipt);
        return receipt;
    }

    @Override
    public boolean delete(String r) {
        Receipt deleteReceipt = read(r);
        this.receiptDB.remove(deleteReceipt);
        return true;
    }
}

