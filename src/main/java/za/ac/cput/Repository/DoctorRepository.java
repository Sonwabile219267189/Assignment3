package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String>
{

}
///*  Doctor.java
//    Repository for the Doctor
//    Author: Bheka Gumede (218223420)
//    Date: 30 July 2021
// */
//
//package za.ac.cput.Repository;

//
//import za.ac.cput.Entity.Doctor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class DoctorRepository implements IDoctorRepository
//
//{
//    private static DoctorRepository repository = null;
//    private Set<Doctor> databaseForDoctor = null;
//
//    private DoctorRepository()
//    {
//        databaseForDoctor = new HashSet<Doctor>();
//    }
//
//    public static DoctorRepository getRepository()
//    {
//        if(repository == null)
//        {
//            repository = new DoctorRepository();
//        }
//        return repository;
//    }
//
//
//    @Override
//    public Doctor create(Doctor doctor)
//    {
//        boolean pass = databaseForDoctor.add(doctor);
//        if(!pass)
//            return null;
//        return doctor;
//    }
//
//
//    @Override
//    public Doctor read(String DoctorID)
//    {
//        for (Doctor readDoctor : databaseForDoctor)
//            if(readDoctor.getDoctorID().equals(DoctorID))
//            {
//                return readDoctor;
//            }
//        return null;
//    }
//
//
//    @Override
//    public Doctor update(Doctor doctor)
//    {
//        Doctor changeDoctor = read(doctor.getDoctorID());
//        if(changeDoctor != null)
//            databaseForDoctor.remove(changeDoctor);
//        databaseForDoctor.add(doctor);
//        return null;
//    }
//
//
//    @Override
//    public boolean delete(String doctorID)
//    {
//        Doctor deleteDoctor = read(doctorID);
//        if(deleteDoctor != null)
//            databaseForDoctor.remove(deleteDoctor);
//        return true;
//    }
//
//
//    @Override
//    public Set<Doctor> getAll()
//    {
//        return databaseForDoctor;
//    }
//
//}