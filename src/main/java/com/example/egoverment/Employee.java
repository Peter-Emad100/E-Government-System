package com.example.egoverment;

import java.time.LocalDate;

public class Employee extends Human{
    private String startingDate;
    public String getStartingDate(){
        return startingDate;
    }
    Employee(String name, int id){
        super(name,id);
        startingDate=LocalDate.now().toString();
    }
}
