package za.ac.cput.Factory;
/*  ConsultationRecordFactory.java
    Factory for ConsultationRecordFactory
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */
import za.ac.cput.Entity.ConsultationRecord;
import za.ac.cput.Util.GenerateConsultationDate;
import za.ac.cput.Util.generateID;

import java.time.LocalDateTime;

public class ConsultationRecordFactory {

    public static ConsultationRecord createConsultationRecord(String description){

        //generate a random unique id for the Consultation
        String consultationID = generateID.generateID();

        LocalDateTime consultationDate = GenerateConsultationDate.generateConsultationDate();

        //check if the Values  are not null
        if (description.isEmpty()  )
        {
            System.out.println("Enter all the required information...");
        }

        ConsultationRecord record = new ConsultationRecord.Builder()
                .setConsultationId(consultationID)
                .setDescription(description)
                .setConsultationDate(consultationDate)
                .build();
        return record;
    }
}
