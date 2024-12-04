package com.example.egoverment;

import java.util.ArrayList;

public class Ministry_Education extends Ministry {


    public Ministry_Education(String name, int id) {

            super(name, id);
            super.departments=new ArrayList<>();
            super.addDepartmentsToMinistry("Department of Primary Stage");
            super.addDepartmentsToMinistry("Department of Preparatory Stage");
            super.addDepartmentsToMinistry("Department of Secondary Stage");

    }
}
