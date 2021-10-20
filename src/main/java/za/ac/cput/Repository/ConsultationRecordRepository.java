//package za.ac.cput.Repository;
//
//import za.ac.cput.Entity.ConsultationRecord;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ConsultationRecordRepository implements IConsultationRecordRepository {
//
//    //static helps with singleton
//    private static ConsultationRecordRepository repository = null;
//
//    private Set<ConsultationRecord> consultationRecordDB = null;
//
//    public ConsultationRecordRepository(){
//        this.consultationRecordDB = new HashSet<>();
//    }
//
//    public static ConsultationRecordRepository getRepository(){
//        if(repository == null){
//            repository = new ConsultationRecordRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Set<ConsultationRecord> getAll() {
//        return consultationRecordDB;
//    }
//
//    @Override
//    public ConsultationRecord create(ConsultationRecord consultationRecord) {
//        this.consultationRecordDB.add(consultationRecord);
//        return consultationRecord;
//    }
//
//    @Override
//    public ConsultationRecord read(String s) {
//        for(ConsultationRecord consultationRecord : this.consultationRecordDB){
//
//            if(consultationRecord.getConsultationId().equalsIgnoreCase(s)){
//                return consultationRecord;
//            }
//
//        }
//        return null;
//    }
//
//    @Override
//    public ConsultationRecord update(ConsultationRecord consultationRecord) {
//        delete(consultationRecord.getConsultationId());
//
//        this.consultationRecordDB.add(consultationRecord);
//        return consultationRecord;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        ConsultationRecord deleteConsultationRecord = read(s);
//        this.consultationRecordDB.remove(deleteConsultationRecord);
//        return true;
//    }
//}
//
