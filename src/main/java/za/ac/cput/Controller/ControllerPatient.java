package za.ac.cput.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Service.PatientServices;

import java.util.Set;
@EnableAutoConfiguration
@RestController
@RequestMapping("/patient")
public class ControllerPatient {


    @Autowired
    private PatientServices patientServices;

    @PostMapping("/create")
    public Patient create(@RequestBody Patient patient){

       Patient newPatient = PatientFactory.build(patient.getPatientName(),patient.getPatientAge(),patient.getGender());

        return patientServices.create(newPatient);


    }
    @PostMapping("/update")
    public Patient update(@RequestBody Patient patient){
        return patientServices.update(patient);
    }

    @GetMapping("/read")
    public Patient read(@RequestBody String id){
        return patientServices.read(id);
    }

    @PostMapping("/delete/{id}")
    public Boolean Delete(@PathVariable String id){
        return patientServices.delete(id);
    }
    @GetMapping("/getall")
    public Set<Patient> getAll(){
        return patientServices.getAll();
    }
}