package com.example.egoverment;

import java.time.LocalDate;

public class Employee extends Human{
    private String startingDate;
    private Department department;

    public Employee(String name, int id){
        super(name,id);
        startingDate=LocalDate.now().toString();
    }
    public String getStartingDate(){
        return startingDate;
    }
    public String getdapname(){
        return department.getDepartmentName();
    }
    public void inDepartment(Department d){
       this.department=d;
    }

}
