package com.example.egoverment;

import java.time.LocalDate;

public class Employee extends Human{
    private String startingDate;


    public Employee(String name, long id){
        super(name,id);
        startingDate=LocalDate.now().toString();
    }
    public String getStartingDate(){
        return startingDate;
    }


}
