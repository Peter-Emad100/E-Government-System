package com.example.egoverment;
import java.util.List;



public class BloodBank {
    private String location;
    private List<BloodBag> availableBloodBags;

    public BloodBank(String location, List<BloodBag> availableBloodBags) {
        this.location = location;
        this.availableBloodBags = availableBloodBags;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<BloodBag> getAvailableBloodBags() {
        return availableBloodBags;
    }

    public void setAvailableBloodBags(List<BloodBag> availableBloodBags) {
        this.availableBloodBags = availableBloodBags;
    }



}