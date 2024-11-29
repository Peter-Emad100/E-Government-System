package com.example.egoverment;

import java.util.ArrayList;
import java.util.Date;

public class Form {
    private String formName;
    ArrayList<Request>requests;
    static int
    public Form (String formName){
        this.formName=formName;
        requests=new ArrayList<Request>();
    }
    public String getFormName() {
        return formName;
    }

    public void addRequesttoForm(String Rname, String Rid , String Rnotices, String Rlocation, Date RbirthDate)
    {
        requests.add(new Request(Rname, Rid, Rnotices, Rlocation, RbirthDate));
    }
}

