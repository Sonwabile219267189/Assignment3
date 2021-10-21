/*  Pharmacy.java
    Entity for the Pharmacy
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Entity;

public class Pharmacy {

    private String medicineID;
    private int quantity;
    private double price;

    private Pharmacy (Builder builder ){

    this.medicineID = builder.medicineID;
    this.price = builder.price;
    this.quantity = builder.quantity;

    }

    public String getMedicineID() {
        return medicineID;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    public static class Builder {
        private String medicineID;
        private double price;
        private int quantity;



        public Builder setMedicineID(String medicineID) {

            this.medicineID = medicineID;
            return this;
        }


        public Builder setQuantity(int quantity) {

            this.quantity = quantity;
            return this;
        }


        public Builder setPrice(double price) {

            this.price = price;
            return this;
        }

        public Pharmacy build() {
            return new Pharmacy(this);
        }


        public Pharmacy.Builder copy(Pharmacy pharmacy) {
            this.medicineID = pharmacy.medicineID;
            this.quantity = pharmacy.quantity;
            this.price = pharmacy.price;

            return this;
        }
    }

    public double totalForProduct(){
        double total;

        total = price*quantity;

        return total;
    }
    public java.lang.String generateBill() {
        return "Pharmacy{" +
                "medicineID=" + medicineID +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total for product=" + totalForProduct() +
                '}';
    }
}
