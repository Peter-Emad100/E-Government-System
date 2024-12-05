package com.example.egoverment;
import java.time.LocalDate;
public class Minister extends Human{
    private String  startingDate;
    Minister(String name, int id){
        super(name,id);
        startingDate=LocalDate.now().toString();
    }
    public String getStartingDate(){
        return startingDate;
    }
}

