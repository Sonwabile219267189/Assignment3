/*  Receipt.java
    Entity for the Receipt
    Author: Zuko Fukula (217299911)
    Date: 6 June 2021
 */

package za.ac.cput.Entity;

public class Receipt {

    private int receiptID;

    private Receipt(Builder builder){

        this.receiptID = builder.receiptID;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public static class Builder {

        private int receiptID;



        public Builder setReceiptID(int receiptID) {
            this.receiptID = receiptID;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }


        public Receipt.Builder copy(Receipt receipt) {
            this.receiptID = receipt.receiptID;
            return this;
        }
    }
    /*public double totalAmount(){
        double grandTotal;

        grandTotal += totalForProduct;
        return grandTotal;
    }*/

    public String generateReceipt() {
        return "Receipt{" +
                "receiptID=" + receiptID +
               // "totalAmountDue=" + totalAmount+
                '}';
    }
}
