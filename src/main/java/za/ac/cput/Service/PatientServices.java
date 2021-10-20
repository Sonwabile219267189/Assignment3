package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Repository.IPatientRepository;



import java.security.Provider;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatientServices implements IPatientService{
    private static PatientServices services =null;

    @Autowired
    public IPatientRepository repository;


    public Patient create(Patient patient){return this.repository.save(patient);}

    public Patient read(String patientID){return this.repository.findById(patientID).orElse(null);}

    public Patient update(Patient patient){
        System.out.println(patient);
        if (this.repository.existsById(patient.getPatientID()))
            return this.repository.save(patient);

        return null;

    }

    public boolean delete(String patientId){
        System.out.println(patientId);

        this.repository.deleteById(patientId);
        if(this.repository.existsById(patientId))
            return false;

        else
            return true;



    }

    public Set<Patient> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());


    }


}
