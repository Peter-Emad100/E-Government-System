package com.example.egoverment;

public class BloodBag {

    private BloodType bloodType;
    private int quantity;



    public BloodBag(BloodType bloodType, int quantity) {
        this.bloodType = bloodType;
        this.quantity = quantity;
    }
    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
