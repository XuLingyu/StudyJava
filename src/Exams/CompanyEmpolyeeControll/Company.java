package Exams.CompanyEmpolyeeControll;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    List<Employee> employees = new ArrayList<>();

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
