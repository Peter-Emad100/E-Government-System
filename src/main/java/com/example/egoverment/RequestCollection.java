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
    public static void prepareRequestsToSave(){
        FileHelper.prepareToSave(requests,savingName);
    }
    public static void retrieve(){
        requests=FileHelper.retrieve(requests,savingName,Request.class);
    }


}
