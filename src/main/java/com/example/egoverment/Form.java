package com.example.egoverment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Form {
    private String formName;
    private int formId;
    ArrayList<Request>requests;
    public Form (String formName, int formId){
        this.formName=formName;
        requests=new ArrayList<Request>();
    }
    public String getFormName() {
        return formName;
    }

    public void addRequesttoForm(String Rname, String Rid , String Rnotices, String Rlocation, LocalDate RbirthDate, boolean gender)
    {
        requests.add(new Request(Rname, Rid, Rnotices, Rlocation, RbirthDate, gender));
    }

    public int getFormId()
    {
        return formId;
    }
}

