/*  PharmacyFactory.java
    Entity for the PharmacyFactory
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Pharmacy;
import java.util.UUID;

public class PharmacyFactory {

    public static Pharmacy createPharmacyItem(int quantity, double price ){
        //unique ID for medicine
        int medicineID = UUID.randomUUID().hashCode();

        //null value check
        if(quantity == 0 || price == 0){
            System.out.println("Values required!");
        }

        Pharmacy ph = new Pharmacy.Builder().setPrice(price).setQuantity(quantity).setMedicineID(medicineID).build();
              return ph;
    }
}
