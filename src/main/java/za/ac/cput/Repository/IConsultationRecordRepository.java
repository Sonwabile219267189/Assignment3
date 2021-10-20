package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.ConsultationRecord;

import java.util.Set;

public interface IConsultationRecordRepository extends JpaRepository<ConsultationRecord, String> {
    Set<ConsultationRecord> getAll();
}
