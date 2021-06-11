package za.ac.cput.Factory;
/*  ConsultationRecordFactoryTest.java
    Test for ConsultationRecordFactory
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.ConsultationRecord;


import static org.junit.jupiter.api.Assertions.*;

class ConsultationRecordFactoryTest {

    @Test
    @Timeout(6)
    // testing when there is not a null ,and the process should timeout at a specified time
    public void createConsultationId() throws InterruptedException {
        Thread.sleep(5000);
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("HIV test");
        System.out.println(sec.getConsultationId());
        assertNotNull(sec.getConsultationId());

    }
    //testing for identity
    @Test
    public void createConsultationDescription(){
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("Pregnancy check up");
        System.out.println(sec.getDescription());
        assertSame("Pregnancy check up",sec.getDescription());
    }
    //testing when there is not a null
    @Test
    public void createConsultationDate(){
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("Pregnancy check up");
        System.out.println(sec.getConsultationDate());
        assertNotNull(sec.getConsultationDate());
    }
}