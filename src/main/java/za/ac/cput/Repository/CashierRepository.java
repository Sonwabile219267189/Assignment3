/*  CashierRepository.java
    This is a interface repository class for cashier entity.
    Author: Khanya Gibisela (217205135)
 */
package za.ac.cput.Repository;

import za.ac.cput.Entity.Cashier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CashierRepository implements ICashierRepository{


    private static CashierRepository repository =null;

    private Set<Cashier> cashierDB=null; // data structure, how the data is stored.

    public static CashierRepository getRepository(){
        if(repository == null){
            repository = new CashierRepository();

        }
        return repository;
    }
    public CashierRepository(){
        cashierDB = new HashSet<Cashier>() {
        };

    }
    public Cashier create(Cashier cashier){
        boolean success =cashierDB.add(cashier);
        if(!success)
            return null;
        return cashier;

    }
    public Cashier read(String itemID){
        for (Cashier c: cashierDB){
            if (c.getItemID().equals(itemID)){
                return c;
            }
            return c;
        }
        return null;
    }

    @Override
    public Cashier update(Cashier cashier){
        Cashier updateCashier = read(cashier.getItemID());
        if(updateCashier!=null){
            cashierDB.remove(updateCashier);
            cashierDB.add(cashier);
            return cashier;
        }
        return null;

    }
    @Override
    public boolean delete (String itemID) {

        Cashier cashierToDelete = read(itemID);
        if(cashierToDelete==null)
            return false;
        cashierDB.remove(cashierToDelete);
        return true;

    }

    @Override
    public Set<Cashier> getAll() {
        cashierDB.toString();
        return cashierDB;
    }
}
