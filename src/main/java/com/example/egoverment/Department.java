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

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /* public  String getEmployee1() {

                return employees.getFirst().getName();
            }*/
   /* public void addEmployee(Employee employee) {
        employees.add(employee);
    }*/
    public boolean removeEmployee(int employeeId) {
        return employees.removeIf(emp -> emp.getId() == employeeId);
    }
    public void addFormtoDepartment(String formName)
    {
        forms.add(new Form(formName));
    }
}
