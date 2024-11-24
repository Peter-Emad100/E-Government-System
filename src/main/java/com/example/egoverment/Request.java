package com.example.egoverment;

import java.util.Date;

public class Request {

    private String notices;
    private String location;
    private Date birthDate;
    private String id;
    private String name;

    public Request(String name,String id ,String notices, String location,Date birthDate){
        this.name=name;
        this.id=id;
        this.birthDate=birthDate;
        this.location=location;
        this.notices=notices;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public String getNotices() {
        return notices;
    }
}

