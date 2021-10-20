/*  CashierFactory.java
    This is a factory  class of a cashier.
    Author: Khanya Gibisela (217205135)
    Date: 11 June 2021
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Cashier;

public class CashierFactory {
    public static Cashier createsCashier(String itemID, String item, int qty, double unitPrice,double discount, double subtotal , double total){
        Cashier cashier = new Cashier.Builder()
                .setItemID(itemID)
                .setItem(item)
                .setQty(qty)
                .setUnitPrice(unitPrice)
                .setDiscount(discount)
                .setSubtotal(subtotal)
                .setTotal(total)
                .build();
        return cashier;
    }
    public static void main(String[] args) {

        Cashier cashier = CashierFactory.createsCashier("1001","Cough Syrup",1,95.00,0.00,95.00,95.00);
        Cashier cashier1 = CashierFactory.createsCashier("1002","Panado",1,100.00,0.00,100.00,100.00);

    }



}