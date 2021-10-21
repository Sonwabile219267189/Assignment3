/*  PharmacyFactory.java
    Entity for the PharmacyFactory
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Util.generateID;

public class PharmacyFactory {

    public static Pharmacy createPharmacyItem(int quantity, double price){
        //unique ID for medicine
         String medicineID = generateID.GenerateID();
        Pharmacy ph = new Pharmacy.Builder().setPrice(price).setQuantity(quantity).setMedicineID(medicineID).build();
              return ph;
    }
}
