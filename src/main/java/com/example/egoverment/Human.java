package com.example.egoverment;

public abstract class Human {
    private String name;
    private long id;
    Human(String name, long id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public long getId(){
        return id;
    }
}

