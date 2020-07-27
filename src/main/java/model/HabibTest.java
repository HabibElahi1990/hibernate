package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "habib_test")
public class HabibTest {
    private Integer id=0;
    private Boolean type;
    private String name;
    private Double salary;

    public HabibTest() {
    }

    public HabibTest(Boolean type, String name, Double salary) {
        this.type = type;
        this.name = name;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HABIB_TEST_SQ")
    @SequenceGenerator(name = "HABIB_TEST_SQ",sequenceName = "SQ_HAT")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type")
    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "HabibTest{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HabibTest habibTest = (HabibTest) o;
        return Objects.equals(type, habibTest.type) &&
                Objects.equals(name, habibTest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
