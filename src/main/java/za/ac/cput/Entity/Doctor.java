/*  Doctor.java
    Entity for the Doctor
    Author: Bheka Gumede (218223420)
    Date: 6 June 2021
 */

package za.ac.cput.Entity;

import javax.persistence.*;

@Entity
@Table(name="DoctorTable")
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String doctorID;
    private String firstName, lastName;
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Doctor(){}
    private Doctor(Builder builder){
        this.doctorID = builder.doctorID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
    }


    public String getDoctorID()
    {
        return doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }



    public static class Builder
    {
        private String doctorID;
        private String firstName, lastName;
        private double salary;

        public Builder  setDoctorID(String doctorID) {
            this.doctorID = doctorID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Doctor build()
        {
            return new Doctor(this);
        }

        public Builder copy(Doctor doctor)
        {
            this.doctorID = doctor.doctorID;
            this.firstName = doctor.firstName;
            this.lastName = doctor.lastName;
            this.salary = doctor.salary;
            return this;
        }

    }
    public Doctor setFirstName(String firstname)
    {
        this.firstName = firstname;
        return this;
    }

    public Doctor setLastName(String lastname)
    {
        this.lastName = lastname;
        return this;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

}
