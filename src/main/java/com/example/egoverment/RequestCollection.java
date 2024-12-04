package com.example.egoverment;

import java.time.LocalDate;
import java.util.ArrayList;

public class RequestCollection {
    public static ArrayList<Request> requests= new ArrayList<>();

    public static void addrequest(String formName, String Rname, String Rid, String Rnotices, String Rlocation, LocalDate RbirthDate, boolean gender)
    {
        RequestCollection.requests.add(new Request(formName, Rname, Rid, Rnotices, Rlocation, RbirthDate, gender));
    }

}
