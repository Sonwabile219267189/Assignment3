package za.ac.cput.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*  Secretary.java
    Entity for Secretary
    Author: Xolani Ganta (216066115)
    Date: 6 June 2021
 */
@Entity
public class Secretary {
    @Id
    private String id,name, lastName;
    private Double salary;

    private Secretary(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static class Builder {
        private String id;
        private String name, lastName;
        private Double salary;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Secretary build() {
            return new Secretary(this);
        }

        public Builder copy(Secretary secretary) {
            this.id = secretary.id;
            this.name = secretary.name;
            this.lastName = secretary.lastName;

            return this;
        }


    }
}