package za.ac.cput.Entity;
/*  ConsultationRecord.java
    Entity for ConsultationRecord
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021.
 */

import java.time.LocalDateTime;

public class ConsultationRecord {
    private String consultationId,description;
    private LocalDateTime consultationDate;

    private ConsultationRecord(ConsultationRecord.Builder builder) {
        this.consultationId = builder.consultationId;
        this.description = builder.description;
        this.consultationDate = builder.consultationDate;
    }
    public String getConsultationId() {
        return consultationId;
    }
    public String getDescription() {
        return description;
    }

    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "id=" + consultationId +
                ", description='" + description + '\'' +
                ", consultationDate=" + consultationDate +
                '}';
    }

    public static class Builder {
        private String consultationId;
        private String description;
        private LocalDateTime consultationDate;

        public ConsultationRecord.Builder setConsultationId(String consultationId) {
            this.consultationId = consultationId;
            return this;
        }

        public ConsultationRecord.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ConsultationRecord.Builder setConsultationDate(LocalDateTime consultationDate) {
            this.consultationDate = consultationDate;
            return this;
        }

        public ConsultationRecord build() {
            return new ConsultationRecord(this);
        }

        public ConsultationRecord.Builder copy(ConsultationRecord consultationRecord) {
            this.consultationId = consultationRecord.consultationId;
            this.description = consultationRecord.description;
            this.consultationDate = consultationRecord.consultationDate;

            return this;
        }


    }
}
