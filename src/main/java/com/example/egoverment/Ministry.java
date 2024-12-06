package com.example.egoverment;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministry {
    static int numberOfMinistries;
    String ministryName;
    private Minister minister;
    protected ArrayList<Department> departments;

    public Ministry(String name){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        ministryName=name;


    }
    public Minister getMinster() {
        return minister;

    }

    public void addDepartmentsToMinistry(String DeptName) {

        departments.add(new Department(DeptName));
    }

}
