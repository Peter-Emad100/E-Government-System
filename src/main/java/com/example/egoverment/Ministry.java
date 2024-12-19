package com.example.egoverment;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministry {
    protected static int numberOfMinistries;
    private String ministryName;
    private Minister minister;
    protected ArrayList<Department> departments;

    public String getMinisterName() {
        return minister.getName();
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    public String getMinistryName() {
        return ministryName;
    }


    public Ministry(String name){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        ministryName=name;


    }
    public Minister getMinster() {
        return minister;

    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

}
