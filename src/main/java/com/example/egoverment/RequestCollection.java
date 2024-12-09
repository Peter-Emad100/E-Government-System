package com.example.egoverment;

import java.time.LocalDate;
import java.util.ArrayList;

public class RequestCollection {
    private final static String savingName="requests";
    public static ArrayList<Request> requests= new ArrayList<>();

    public static void addRequest(String formName, String Rname, String Rid, String Rnotices, String Rlocation, String RbirthDate, boolean gender)
    {
        RequestCollection.requests.add(new Request(formName, Rname, Rid, Rnotices, Rlocation, RbirthDate, gender));
    }
    /*static{
        requests.add(new Request("c","c","c","c","c","c",true));
        requests.add(new Request("c","c","c","c","c","c",true));
        requests.add(new Request("c","c","c","c","c","c",true));
        requests.add(new Request("c","c","c","c","c","c",true));
        requests.add(new Request("c","c","c","c","c","c",true));
    }*/
    public static void prepareRequestsToSave(){
        FileHelper.prepareToSave(requests,savingName);
    }
    public static void retrieve(){
        requests=FileHelper.retrieve(requests,savingName,Request.class);
    }


}
