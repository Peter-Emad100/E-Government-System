package com.example.egoverment;
import java.time.LocalDate;
public class Minister extends Human{
    private LocalDate startingDate;
    Minister(String name, int id){
        super(name,id);
        startingDate=LocalDate.now();
    }
    public LocalDate getStartingDate(){
        return startingDate;
    }
}

