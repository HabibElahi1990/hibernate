package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
public class HabibColl implements Serializable {


    private Integer id;
    private String firstName;
    private String lastName;
    private List<HabibTest> habibTestList;
    private Map<String, HabibTest> habibTestMap;
    private Set<HabibTest> habibTestSet;

    public HabibColl() {
    }

    public HabibColl(String firstName, String lastName, List<HabibTest> habibTestList, Map<String, HabibTest> habibTestMap, Set<HabibTest> habibTestSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.habibTestList = habibTestList;
        this.habibTestMap = habibTestMap;
        this.habibTestSet = habibTestSet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_Name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "HabibTest_list")
    public List<HabibTest> getHabibTestList() {
        return habibTestList;
    }

    public void setHabibTestList(List<HabibTest> habibTestList) {
        this.habibTestList = habibTestList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "HabibTest_map")
    public Map<String, HabibTest> getHabibTestMap() {
        return habibTestMap;
    }

    public void setHabibTestMap(Map<String, HabibTest> habibTestMap) {
        this.habibTestMap = habibTestMap;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "HabibTest_set")
    public Set<HabibTest> getHabibTestSet() {
        return habibTestSet;
    }

    public void setHabibTestSet(Set<HabibTest> habibTestSet) {
        this.habibTestSet = habibTestSet;
    }

    @Override
    public String toString() {
        return "HabibTmp{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
