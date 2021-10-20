package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.ConsultationRecord;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Repository.IConsultationRecordRepository;
import za.ac.cput.Repository.ISecretaryRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service //acts as a service over the internet
public class ConsultationService implements IConsultationService {

    @Autowired //enforces singleton
    private IConsultationRecordRepository consultationRepository;


    @Override
    public ConsultationRecord create(ConsultationRecord t) {
        return this.consultationRepository.save(t);
    }

    @Override
    public ConsultationRecord read(String s) {
        return this.consultationRepository.findById(s).orElseGet(null);
    }

    @Override
    public ConsultationRecord update(ConsultationRecord t) {
        return this.consultationRepository.save(t);
    }

    @Override
    public boolean delete(String s) {
        this.consultationRepository.deleteById(s);
        if (this.consultationRepository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<ConsultationRecord> getAll() {
        return this.consultationRepository.findAll().stream().collect(Collectors.toSet());
    }
}

