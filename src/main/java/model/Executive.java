package model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "Executive")
public class Executive extends Employee {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Executive{" +
                "role='" + role + '\'' +
                '}';
    }
}
