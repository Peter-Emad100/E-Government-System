package com.example.egoverment;

public class User extends Loginer {
    private String phone;
    static int numberOfUsers;
    User(String name, long id, String loginName, String hashedPassword,String phone,String mail) {
        super(name, id,loginName,hashedPassword,mail);
        this.phone=phone;
        numberOfUsers++;
    }

    public String getPhone() {
        return phone;
    }
}
