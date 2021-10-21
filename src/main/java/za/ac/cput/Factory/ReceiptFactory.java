/*  ReceiptFactory.java
    Entity for the ReceiptFactory
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Util.generateID;

public class ReceiptFactory {
    public static Receipt createReceiptItem(String receiptID){
        //unique ID for receipt
       receiptID= generateID.GenerateID();

        Receipt rcp = new Receipt.Builder().setReceiptID(receiptID).build();
        return rcp;
    }
}
