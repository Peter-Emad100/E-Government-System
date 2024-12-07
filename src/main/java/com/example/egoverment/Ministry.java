package com.example.egoverment;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministry {
    static int numberOfMinistries;
    String ministryName;
    private Minister minister;
    protected ArrayList<Department> departments;

    public String getMinisterName() {
        return minister.getName();
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    public String getMinistryName() {
        return ministryName;
    }


    public Ministry(String name){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        ministryName=name;


    }
    public Minister getMinster() {
        return minister;

    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void addDepartmentsToMinistry(String DeptName) {

        departments.add(new Department(DeptName));
    }
    public Department findDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }
}
