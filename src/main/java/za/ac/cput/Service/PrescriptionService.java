/**
 * PrescriptionService.java
 * Author: Sonwabile Gxoyiya
 */
package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Prescription;
import za.ac.cput.Repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionService implements IPrescriptionService{

    private static PrescriptionService prescriptionService = null;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<Prescription> getAll() {
        return null;
    }

    @Override
    public Prescription create(Prescription prescription) {

        return null;
    }

    @Override
    public Prescription read(String s) {
        return null;
    }

    @Override
    public Prescription update(Prescription prescription) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
