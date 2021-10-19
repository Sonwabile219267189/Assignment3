package za.ac.cput.Entity;

//PATIENT.JAVA
//eNTITY FOR THE PATIENT
//Author Stefan Groenewald(219104891)
//Date 05/06/2021

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Patient")
@Getter
@Setter
public class Patient {
    @Id
    private String patientID;
    private String firstName;
    private int age;
    private String gender;

    private Patient(){}

    public void generateReport(){
        System.out.println("Patient{" +
                "patientID=" + patientID +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}');


    }
    public void payBill(){}

    public Patient (Builder builder){
        this.age=builder.age;
        this.firstName=builder.firstName;
        this.patientID= builder.patientID;
        this.gender=builder.gender;


    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return firstName;
    }

    public int getPatientAge(){return age;}

    public String getGender(){return gender;}

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public static class Builder {

        private String patientID;
        private String firstName;
        private int age;
        private String gender;


        public Builder ID(String patientID) {
            this.patientID = patientID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Patient building() {

            return new Patient(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "patientID=" + patientID +
                    ", firstName='" + firstName + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
        public Builder clone(Patient pat){
            this.age=pat.age;
            this.firstName=pat.firstName;
            this.patientID= pat.patientID;
            this.gender=pat.gender;
            return this;
        }

    }
    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", setfirstName='" + firstName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}