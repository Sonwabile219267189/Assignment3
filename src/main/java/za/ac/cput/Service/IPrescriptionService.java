/**
 * IPrescriptionService.java
 * Author: Sonwabile Gxoyiya
 */
package za.ac.cput.Service;


import za.ac.cput.Entity.Prescription;

import java.util.List;

public interface IPrescriptionService extends IService<Prescription, String>{
    public List<Prescription> getAll();
}
