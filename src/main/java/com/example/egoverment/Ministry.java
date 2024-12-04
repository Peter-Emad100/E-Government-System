package com.example.egoverment;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministry {
    static int numberOfMinistries;
    private Minister minister;
    protected ArrayList<Department> departments;

    public Ministry(String name, int id){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        minister=new Minister(name,id);
    }
    public Minister getMinster() {
        return minister;

    }

    public void addDepartmentsToMinistry(String DeptName) {

        departments.add(new Department(DeptName));
    }

}
