package com.example.egoverment;

public class User extends Loginer{
    private String phone;
    private String mail;
    User(String name, int id, String loginName, String hashedPassword,String phone,String mail) {
        super(name, id,loginName,hashedPassword);
        this.phone=phone;
        this.mail=mail;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
}
