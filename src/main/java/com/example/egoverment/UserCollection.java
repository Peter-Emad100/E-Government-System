package com.example.egoverment;

public class UserCollection extends AbstractCollection<User>  {
    public void add(String name, int id, String loginName, String hashedPassword){
        super.subLoginers.add(new User(name,id,loginName,hashedPassword));
    }
}

