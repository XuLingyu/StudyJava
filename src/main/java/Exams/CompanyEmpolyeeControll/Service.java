package Exams.CompanyEmpolyeeControll;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    public static Employee getSuperior(String superiorId, List<Employee> employees){
        for(Employee e: employees){
            if(superiorId.equals(e.getId()))
                return e;
        }
        return new Employee();
    }

    public static List<Employee> generateEmployees(File file) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if (file == null)
                return null;
            else {
                while (true) {
                    //String line = bufferedReader.readLine().replaceAll(" ",""); NullPointerException
                    String line = bufferedReader.readLine();
                    List<String> lineArr = new ArrayList<>();
                    if (line == null)
                        break;

                    for(String str: line.split(","))
                        lineArr.add(str.trim());

                    if (lineArr.size() == 3)
                        employees.add(new Employee(lineArr.get(0), lineArr.get(1), lineArr.get(2)));
                    else if (lineArr.size() == 2)
                        employees.add(new Employee(lineArr.get(0), lineArr.get(1), ""));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(employees);
        return employees;
    }

    public static List<Employee> calculateLevel(List<Employee> employees){
        for(Employee employee : employees){
            int level = 0;
            Employee temp = employee;
            while(true){
                if(temp.getSuperiorId().equals(""))
                    break;
                temp = getSuperior(temp.getSuperiorId(), employees);
                level++;
            }
            employee.setLevel(level);
        }
        return employees;
    }

    public static List<Employee> calculateSubordinate(List<Employee> employees){
        for(Employee e: employees){
            List<String> stringList = new ArrayList<>();
            for(Employee e2: employees){
                if(e2.getSuperiorId().equals(e.getId()))
                    stringList.add(e2.getId());
            }
            e.setSubordinate(stringList);
        }
        return employees;

    }
    public static void main(String[] args) {
        File file = new File("E:\\SSM\\StudyJava\\src\\Exams\\CompanyEmpolyeeControll\\Employees.txt");
        List<Employee> employees = generateEmployees(file);
        System.out.println("generateEmployees: ");
        employees.forEach(employee -> System.out.println(employee));

        employees = calculateLevel(employees);
        System.out.println("calculateLevel: ");


        employees = calculateSubordinate(employees);
        System.out.println("calculateSubordinate: ");
        employees.forEach(employee -> System.out.println(employee));

        System.out.println("Sort: ");
        employees.stream()
                .sorted((e1,e2) -> Integer.parseInt(e1.id) - Integer.parseInt(e2.id))
                .forEach(e -> System.out.println(e));



    }
}
