/*  Cashier.java
    This is an entity of a cashier within the operation of the staff in the clinic.
    Author: Khanya Gibisela (217205135)
    Date: 11 June 2021
 */
package za.ac.cput.Entity;

public class Cashier  {

    private int cashierID = 988795;
    private String name= "Felicia";
    private String lastname= "Jacobs";
    private double salary = 950.000;

    public Cashier(Builder builder) {
        this.cashierID = builder.cashierID;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.salary = builder.salary;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "cashierID=" + cashierID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                '}';
    }

    protected Cashier(int cashierID, String name, String lastname, double salary) {
        this.cashierID = cashierID;
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
    }

    public static class Builder{
        private int cashierID;
        private String name;
        private String lastname;
        private double salary;


        public Builder setCashierID(int cashierID) {
            this.cashierID = cashierID;
            return this;
        }


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;

            return this;
        }


        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }
        public Cashier build() {
            return new Cashier (cashierID, name, lastname,salary);
        }
        public Builder copy (Cashier cashier) {
            this.cashierID = cashier.cashierID;
            this.name = cashier.name;
            this.lastname = cashier.lastname;
            this.salary = cashier.salary;
            return this;
        }


    }
}
