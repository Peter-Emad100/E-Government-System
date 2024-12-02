package com.example.egoverment;

public enum BloodType {
    A_POS("A+"),
    A_NEG("A-"),
    B_POS("B+"),
    B_NEG("B-"),
    AB_POS("AB+"),
    AB_NEG("AB-"),
    O_POS("O+"),
    O_NEG("O-");

    private final String type;

    BloodType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
    //helps in displaying the value in string representation rather than Enum ( "A+" instead of A_POS)
    @Override
    public String toString() {
        return type;
    }
}
