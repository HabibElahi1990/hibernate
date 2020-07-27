package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class HabibStudent implements Serializable {

    private Integer avg;
    private HabibPerson person;
    private List<HabibCourse> courseList;
    private HabibTest test;

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    public HabibPerson getPerson() {
        return person;
    }

    public void setPerson(HabibPerson person) {
        this.person = person;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    public List<HabibCourse> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<HabibCourse> courseList) {
        this.courseList = courseList;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public HabibTest getTest() {
        return test;
    }

    public void setTest(HabibTest test) {
        this.test = test;
    }
}
