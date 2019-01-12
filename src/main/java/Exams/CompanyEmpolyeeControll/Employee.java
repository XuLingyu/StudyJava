package Exams.CompanyEmpolyeeControll;

import java.util.ArrayList;
import java.util.List;

public class Employee{
    String id;
    String name;
    String superiorId;
    List<String> subordinate;
    int level;

    public Employee(String id, String name, String superior) {
        this.id = id;
        this.name = name;
        this.superiorId = superior;
        subordinate = new ArrayList<>();
        level = 0;
    }

    public Employee() {
        this(null, null, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(String superiorId) {
        this.superiorId = superiorId;
    }

    public List<String> getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(List<String> subordinate) {
        this.subordinate = subordinate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", superiorId='" + superiorId + '\'' +
                ", subordinate=" + subordinate +
                ", level=" + level +
                '}';
    }

}
