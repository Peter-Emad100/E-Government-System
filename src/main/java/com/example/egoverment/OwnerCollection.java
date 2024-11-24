package com.example.egoverment;

public class OwnerCollection extends AbstractCollection<Owner> {
    public void add(String name, String id, String loginName, String hashedPassword){
        super.subLoginers.add(new Owner(name,id,loginName,hashedPassword));
    }
}
