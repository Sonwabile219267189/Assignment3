///*  CashierRepository.java
//    This is a interface repository class for cashier entity.
//    Author: Khanya Gibisela (217205135)
// */
//package za.ac.cput.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import za.ac.cput.Entity.Cashier;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//@Deprecated
//public class CashierRepository implements ICashierRepository {
//
//
//    private static CashierRepository repository =null;
//
//    private Set<Cashier> cashierdb=null; // data structure, how the data is stored.
//
//    public static CashierRepository getRepository(){
//        if(repository == null){
//            repository = new CashierRepository();
//
//        }
//        return repository;
//    }
//    public CashierRepository(){
//        cashierdb = new HashSet<Cashier>() {
//        };
//
//    }
//    public Cashier create(Cashier cashier){
//        boolean success =cashierdb.add(cashier);
//        if(!success)
//            return null;
//        return cashier;
//
//    }
//    public Cashier read(String itemID){
//        Cashier cashier = cashierdb
//                .stream()
//                .filter(c -> c.getItemID().equals(itemID))
//                .findAny()
//                .orElse(null);
//        return cashier;
//
//    }
//
//    @Override
//    public Cashier update(Cashier cashier){
//        Cashier updateCashier = read(cashier.getItemID());
//        if(updateCashier!=null){
//            cashierdb.remove(updateCashier);
//            cashierdb.add(cashier);
//            return cashier;
//        }
//        return null;
//
//    }
//    @Override
//    public boolean delete (String itemID) {
//
//        Cashier cashierToDelete = read(itemID);
//        if(cashierToDelete==null)
//            return false;
//        cashierdb.remove(cashierToDelete);
//        return true;
//
//    }
//
//    @Override
//    public Set<Cashier> getAll() {
//        cashierdb.toString();
//        return cashierdb;
//    }
//}
