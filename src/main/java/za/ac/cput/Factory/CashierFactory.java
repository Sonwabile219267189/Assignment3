/*  CashierFactory.java
    This is a factory  class of a cashier.
    Author: Khanya Gibisela (217205135)
    Date: 11 June 2021
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Cashier;

public class CashierFactory {
    public static Cashier createsCashier(int cashierID,String name, String lastname, double salary){
        Cashier cashier = new Cashier.Builder()
                .setCashierID(cashierID)
                .setName(name)
                .setLastname(lastname)
                .setSalary(salary)
                .build();
        return cashier;
    }
    public static void main(String[] args) {

        Cashier cashier = CashierFactory.createsCashier(12345,"Felicia","Jacobs",950.000);
        Cashier cashier1 = CashierFactory.createsCashier(52684,"Amanda", "London",950.000);

    }


}