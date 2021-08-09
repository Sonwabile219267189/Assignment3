package za.ac.cput.Repository;

import za.ac.cput.Entity.Patient;

import java.util.HashSet;
import java.util.Set;

public class PatientRepostitory implements IPatientRepository{

    private HashSet<Patient> patDatabase=null;
    private static PatientRepostitory repository =null;



        public static PatientRepostitory getRepository(){
            if(repository == null){
                repository = new PatientRepostitory();

            }
            return repository;
        }
        public PatientRepostitory(){
        patDatabase = new HashSet<Patient>() {
        };

             }
        public Patient create(Patient pat){
            boolean success =patDatabase.add(pat);
            if(!success)
                return null;
            return pat;

        }

    public Patient read(String patientID){
            for (Patient p : patDatabase){
                if (p.getPatientID().equals(patientID)){
                    return p;
                }
                return p;
            }
            return null;
        }

        @Override
        public Patient update(Patient pat){
            Patient prefPatient = read(pat.getPatientID());
            if(prefPatient!=null){
                patDatabase.remove(prefPatient);
                patDatabase.add(pat);
                return pat;
            }
                return null;

        }

    @Override
        public boolean delete(String patID) {

            Patient patientToDelete = read(patID);
            if(patientToDelete==null)
                return false;
            patDatabase.remove(patientToDelete);
            return true;

        }

    @Override
    public Set<Patient> getAll() {
            patDatabase.toString();
            return patDatabase;
    }
}
