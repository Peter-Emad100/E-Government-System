package com.example.egoverment;

import java.util.ArrayList;
public class Department {
    private String departmentName;
    private int departmentID;
    private ArrayList<Employee> employees;
    ArrayList<Form> forms;

    public Department(String departmentName, int departmentID){
        this.departmentName=departmentName;
        this.departmentID=departmentID;
        employees=new ArrayList<Employee>();
        forms=new ArrayList<Form>();
    }
    public String getDepartmentName(){
        return departmentName;
    }

    public int getDepartmentID(){
        return departmentID;
    }


    public void addEmployeetoDepartment(String empName, String empID)
    {
        employees.add(new Employee(empName, empID));
    }
    public void addFormtoDepartment(String formName, int formId)
    {
        forms.add(new Form(formName, formId));
    }
}
