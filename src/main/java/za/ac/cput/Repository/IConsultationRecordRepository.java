package za.ac.cput.Repository;

import za.ac.cput.Entity.ConsultationRecord;

import java.util.Set;

public interface IConsultationRecordRepository extends IRepository<ConsultationRecord, String>{
    Set<ConsultationRecord> getAll();
}
