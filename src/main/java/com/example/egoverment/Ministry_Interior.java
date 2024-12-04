package com.example.egoverment;
import java.util.ArrayList;
import java.util.Date;

public class Ministry_Interior extends Ministry {


    public Ministry_Interior(String name, int id)
    {
        super(name, id);
        super.departments=new ArrayList<>();
        super.addDepartmentsToMinistry("Department of Civil Status");
        super.departments.get(0).addFormtoDepartment("Renew Social Security Number");

    }









}
