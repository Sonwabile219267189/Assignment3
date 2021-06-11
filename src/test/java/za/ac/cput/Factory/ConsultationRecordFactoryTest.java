package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.ConsultationRecord;
import za.ac.cput.Entity.Secretary;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationRecordFactoryTest {

    @Test
    @Timeout(6)
    public void createConsultationId() throws InterruptedException {
        Thread.sleep(5000);
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("HIV test");
        System.out.println(sec.getConsultationId());
        assertNotNull(sec.getConsultationId());

    }
    @Test
    public void createConsultationDescription(){
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("Pregnancy check up");
        System.out.println(sec.getDescription());
        assertSame("Pregnancy check up",sec.getDescription());
    }
    @Test
    public void createConsultationDate(){
        ConsultationRecord sec = ConsultationRecordFactory.createConsultationRecord("Pregnancy check up");
        System.out.println(sec.getConsultationDate());
        assertNotNull(sec.getConsultationDate());
    }
}