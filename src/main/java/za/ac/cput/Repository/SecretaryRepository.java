//package za.ac.cput.Repository;
//
//
//import za.ac.cput.Entity.Secretary;
//
//import java.util.HashSet;
//import java.util.Set;
//@Deprecated
//
//public class SecretaryRepository implements ISecretaryRepository {
//
//    //static helps with singleton
//    private static SecretaryRepository repository = null;
//
//    private Set<Secretary> secretaryDB = null;
//
//    public SecretaryRepository(){
//        this.secretaryDB = new HashSet<>();
//    }
//
//    public static SecretaryRepository getRepository(){
//        if(repository == null){
//            repository = new SecretaryRepository();
//        }
//        return repository;
//    }
//
//
//    @Override
//    public Secretary create(Secretary secretary) {
//        this.secretaryDB.add(secretary);
//        return secretary;
//    }
//
//    @Override
//    public Secretary read(String s) {
//        for(Secretary secretary : this.secretaryDB){
//
//            if(secretary.getId().equalsIgnoreCase(s)){
//                return secretary;
//            }
//
//        }
//        return null;
//    }
//
//
//    @Override
//    public Secretary update(Secretary secretary) {
//        delete(secretary.getId());
//
//        this.secretaryDB.add(secretary);
//        return secretary;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        Secretary deleteSecretary = read(s);
//        this.secretaryDB.remove(deleteSecretary);
//        return true;
//    }
//
//    @Override
//    public Set<Secretary> getAll() {
//        return secretaryDB;
//    }
//}
//
