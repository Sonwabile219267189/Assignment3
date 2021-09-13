package za.ac.cput.Repository;


import za.ac.cput.Entity.Prescription;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrescriptionRepository //implements IPrescriptionRepository
{

    private static PrescriptionRepository repository = null;
    private List<Prescription> prescriptionDB = null;

    private PrescriptionRepository(){
        prescriptionDB = new LinkedList<Prescription>();

    }


    public static PrescriptionRepository getRepository(){
        if (repository == null)
        {
            repository = new PrescriptionRepository();
        }
        return repository;
    }

    //@Override
    public Prescription create(Prescription prescription){
        boolean success = prescriptionDB.add(prescription);
        if(!success){
            return null;
        }
        return prescription;
    }

    //@Override
    public Prescription read(String prescriptionId){
        for (Prescription p : prescriptionDB){
            if (p.getClass().equals(prescriptionId)){
                return p;
            }

        }
        return null;
    }


    //@Override
    //public Prescription update(Prescription prescription){}
    //@Override
    public List<Prescription> getAll(){

        return prescriptionDB;
    }


    //@Override
    //public Prescription delete(Prescription p){}
}
