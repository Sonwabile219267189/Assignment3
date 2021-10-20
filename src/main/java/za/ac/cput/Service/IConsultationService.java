package za.ac.cput.Service;

import za.ac.cput.Entity.ConsultationRecord;

import java.util.Set;

public interface IConsultationService extends IService<ConsultationRecord, String> {
    Set<ConsultationRecord> getAll();
}
