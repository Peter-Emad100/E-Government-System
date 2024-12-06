package com.example.egoverment;

import javafx.event.ActionEvent;

/*public class SignUp extends Loginer{
    private int mobileNum;
    private String address;

    SignUp(String name,int id, String loginName, String Password, int mobileNum, String address) {
        super(name, id, loginName, Password);
        this.mobileNum = mobileNum;
        this.address = address;
    }
    public int getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        String mobileStr = String.valueOf(mobileNum);
        if (mobileStr.length() != 11) {
            System.out.println("Mobile number must be 11 digits long.");
        } else {
            this.mobileNum = mobileNum;
        }
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Address cannot be empty.");
        } else {
            this.address = address;
        }
    }

    /* Method to complete the user registration by validating all fields *//*
    public void registerUser(String name, String id, String loginName, String password, int mobileNum, String address) {
        setLoginName(loginName);
        setPassword(password);
        setMobileNum(mobileNum);
        setAddress(address);

        if (this.getLoginName() != null && this.getPassword() != null && this.mobileNum > 0 && this.address != null && !this.address.trim().isEmpty()) {
            System.out.println("User successfully registered!");
        } else {
            System.out.println("Registration failed.");
        }
    }

}*/

