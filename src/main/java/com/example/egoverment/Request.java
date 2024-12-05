package com.example.egoverment;

import java.time.LocalDate;
import java.util.Date;

public class Request {

    private String formName;
    private String notices;
    private String location;
    private String birthDate;
    private String id;
    private String name;
    private boolean gender;

    public Request(String formName, String name, String id ,String notices, String location, String birthDate, boolean gender){
        this.formName=formName;
        this.name=name;
        this.id=id;
        this.birthDate=birthDate;
        this.location=location;
        this.notices=notices;
        this.gender=gender;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public String getNotices() {
        return notices;
    }

    public String getFormName() { return formName; }

    public boolean getGender() { return gender; }
}

