package com.example.egoverment;

import java.util.ArrayList;
public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;
    ArrayList<Form> forms;
    public Department(String departmentName){
        this.departmentName=departmentName;
        employees=new ArrayList<Employee>();
        forms=new ArrayList<Form>();
    }
    public String getDepartmentName(){
        return departmentName;
    }
}
