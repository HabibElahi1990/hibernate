package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Habib_Embeddable_Test")
public class HabibEmbeddableTest {

    @Id
    private HabibEmbeddableTestPK id;

    @Column(name = "name")
    private String name;
    @Column(name = "creation_Date")
    private Date creationDate;

    public HabibEmbeddableTestPK getId() {
        return id;
    }

    public void setId(HabibEmbeddableTestPK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "HabibEmbeddableTest{" +
                "id=" + id.toString() +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
