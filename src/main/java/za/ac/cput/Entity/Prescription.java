/*  Prescription.java
    Entity for the Employee
    Author: Sonwabile Gxoyiya (219267189)
    Date: 6 June 2021
 */

package za.ac.cput.Entity;

public class Prescription {
    private int prescriptionID;
    private int medicineID;
    private String medicineName;
    private String directions;
    private int dosage;
    private String prescriptionDate;
    private String reason;


    public Prescription(Builder builder){
        this.prescriptionID = builder.prescriptionID;
        this.prescriptionDate = builder.prescriptionDate;
        this.medicineID = builder.medicineID;
        this.medicineName = builder.medicineName;
        this.directions = builder.directions;
        this.dosage = builder.dosage;
        this.reason = builder.reason;
    }

    public static class Builder{
        private String medicineName, directions, prescriptionDate, reason ;
        private int dosage;
        private int medicineID;
        private int prescriptionID;

        public Builder setPrescriptionID(int prescriptionID){
            this.prescriptionID = prescriptionID;
            return this;
        }

        public Builder setMedicineID(int medicineID){
            this.medicineID = medicineID;
            return this;
        }

        public Builder setMedicineName(String medicineName){
            this.medicineName = medicineName;
            return this;
        }

        public Builder setDirections(String directions){
            this.directions = directions;
            return this;
        }

        public Builder setPrescriptionDate(String prescriptionDate){
            this.prescriptionDate = prescriptionDate;
            return this;
        }

        public Builder setReason(String reason){
            this.reason = reason;
            return this;
        }

        public Builder setDosage(int dosage){
            this.dosage = dosage;
            return this;
        }
    }
}
