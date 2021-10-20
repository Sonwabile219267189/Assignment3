/*
    PrescriptionFactory.java
    Factory for the Prescription class
    Author: Sonwabile Gxoyiya (219267189)
    Date: 8 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Prescription;
import za.ac.cput.Util.CreateID;

public class PrescriptionFactory {

    public static Prescription build(String prescriptionDate, String direction, int dosage, String reason){
        String prescriptionID = CreateID.createUUID();
        return new Prescription.Builder()
                .setPrescriptionID(prescriptionID)
                .setPrescriptionDate(prescriptionDate)
                .setDirections(direction)
                .setDosage(dosage)
                .setReason(reason).build();
    }

}
