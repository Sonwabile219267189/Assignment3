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

    private HashSet<Cashier> cashierDB=null;
    private static CashierRepository repository =null;



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
    public Cashier read(String cashierID){
        for (Cashier c: cashierDB){
            if (c.getCashierID().equals(cashierID)){
                return c;
            }
            return c;
        }
        return null;
    }

    @Override
    public Cashier update(Cashier cashier){
        Cashier updateCashier = read(cashier.getCashierID());
        if(updateCashier!=null){
            cashierDB.remove(updateCashier);
            cashierDB.add(cashier);
            return cashier;
        }
        return null;

    }
    @Override
    public boolean delete (String cashierID) {

        Cashier cashierToDelete = read(cashierID);
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
