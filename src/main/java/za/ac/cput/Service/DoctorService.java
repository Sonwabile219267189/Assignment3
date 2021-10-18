package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Repository.DoctorRepository;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DoctorService implements IDoctorService
{
    private static DoctorService service = null;

    @Autowired
    private DoctorRepository repository = null;


// private DoctorService()
// {
//     this.repository = DoctorRepository.getRepository();
// }
//
// public static DoctorService getService()
// {
//     if(service == null)
//     {
//         service = new DoctorService();
//     }
//     return service;
// }

    @Override
    public Doctor create(Doctor doctor)
    {
        return this.repository.save(doctor);
    }

    @Override
    public Doctor read(String doctorID)
    {
        return this.repository.findById(doctorID).orElse(null);

    }

    @Override
    public Doctor update(Doctor doctor)
    {
        if(this.repository.existsById(doctor.getDoctorID()))
            return this.repository.save(doctor);
        else
            return null;

    }
    @Override
    public boolean delete(String doctorID)
    {
        this.repository.deleteById(doctorID);
        if(this.repository.existsById(doctorID))
            return false;
        else
            return true;
    }

    @Override
    public Set<Doctor> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    public Set<Doctor> getAllDoctorStartWithB()
    {
        Set<Doctor> doctorsWithB = new HashSet<Doctor>();
        Set<Doctor> doctors = getAll();
        for(Doctor doctor : doctors)
        {
            if(doctor.getFirstName().trim().toLowerCase().startsWith("b"))
            {
                doctorsWithB.add(doctor);
            }
        }

        return doctorsWithB;
    }

}
