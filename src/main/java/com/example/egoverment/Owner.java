package com.example.egoverment;
import java.util.ArrayList;

public class Owner extends Loginer {
    private ArrayList<Department> departments;

    Owner(String name, int id, String loginName, String hashedPassword) {
        super(name, String.valueOf(id),loginName,hashedPassword);
        departments = new ArrayList<>();
    }
    protected void AddEmployeeInDepartment(){
        
    }
}

