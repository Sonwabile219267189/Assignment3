package za.ac.cput.Controller;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.ConsultationRecord;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Factory.ConsultationRecordFactory;
import za.ac.cput.Factory.SecretaryFactory;
import za.ac.cput.Service.ConsultationService;
import za.ac.cput.Service.SecretaryService;

@RestController
@RequestMapping("/Assignment3/ConsultationRecord") // class will be listening to requests through this path
public class ConsultationRecordController {

    @Autowired
    // injecting the object of Auditor services into controllers so it can be manipulated over internet requests
    private ConsultationService ConsultationRecordService;

    // methods as per the Auditor service impl

    @PostMapping("/create") // Post is used to create a new record
    public ConsultationRecord create(@RequestBody ConsultationRecord consultationRecord){
        ConsultationRecord creatingNewConsultationRecord = ConsultationRecordFactory.createConsultationRecord(consultationRecord.getDescription());
        return ConsultationRecordService.create(creatingNewConsultationRecord);
    }

    @GetMapping("/read/{id}") // makes the variable part of the path, to specify what you actually trying to read
    public ConsultationRecord read (@PathVariable String id)
    {
        ConsultationRecord reading = ConsultationRecordService.read(id);
        return reading;
    }

    @PutMapping("/update") // Put is to update an existing record
    public ConsultationRecord update(@RequestBody ConsultationRecord consultationRecord)
    {
        ConsultationRecord updated = ConsultationRecordService.update(consultationRecord);
        return updated;
    }

    @DeleteMapping("/delete/{id}") // makes the variable part of the path, to specify what you actually trying to delete
    public boolean delete(@PathVariable String id)
    {
        boolean deleted = ConsultationRecordService.delete(id);
        return deleted;
    }

    @GetMapping("/all")
    public Set getAll(){
        return (Set) ConsultationRecordService.getAll();
    }
}
