package com.example.egoverment;

import java.time.LocalDate;
import java.util.Date;

public class Request {

    private String notices;
    private String location;
    private LocalDate birthDate;
    private String id;
    private String name;
    private boolean gender;

    public Request(String name, String id ,String notices, String location, LocalDate birthDate, boolean gender){
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public String getNotices() {
        return notices;
    }
}

