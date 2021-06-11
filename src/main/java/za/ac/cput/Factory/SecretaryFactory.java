package za.ac.cput.Factory;
/*  SecretaryFactory.java
    Factory for Secretary
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Util.generateID;

public class SecretaryFactory {

    public static Secretary createSecretary(String Name,String LastName,Double salary){

       //generate a random unique id for the secretary
        String ID = generateID.GenerateID();
        
        //check if the values are not null
        if (Name.isEmpty() || LastName.isEmpty() || salary == 0  )
        {
            System.out.println("Enter all the required information..");
        }

        Secretary secr = new Secretary.Builder()
                .setId(ID)
                .setName(Name)
                .setLastName(LastName)
                .build();
        return secr;
    }


    }

