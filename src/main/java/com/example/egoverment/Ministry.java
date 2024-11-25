package com.example.egoverment;
import java.util.ArrayList;

public class Ministry {
    static int numberOfMinistries;
    private Minister minister;
    private ArrayList<Department> departments;
    public Ministry(String name , String id){
        numberOfMinistries++;
        departments=new ArrayList<Department>();
        minister=new Minister(name,id);
    }
    public Minister getMinster() {
        return minister;
    }
}
