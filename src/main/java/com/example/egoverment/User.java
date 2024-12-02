package com.example.egoverment;

public class User extends Loginer{
    User(String name, int id, String loginName, String hashedPassword) {
        super(name, String.valueOf(id),loginName,hashedPassword);
    }
}
