/*  ReceiptFactory.java
    Entity for the ReceiptFactory
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Receipt;
import java.util.UUID;

public class ReceiptFactory {
    public static Receipt createReceiptItem(){
        //unique ID for receipt
       int receiptID= UUID.randomUUID().hashCode();

        Receipt rcp = new Receipt.Builder().setReceiptID(receiptID).build();
        return rcp;
    }
}
