package com.example.egoverment;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class UserCollection  {
    static GenericLoginerCollec<User> genericLoginerCollec=new GenericLoginerCollec<User>();
    private final static String savingName="users";
    public void add(String name, int id, String loginName, String hashedPassword,String phone,String mail){
        genericLoginerCollec.subLoginers.add(new User(name,id,loginName,hashedPassword,phone,mail));
    }
    public static void prepareToSave(){
        FileHelper.prepareToSave(genericLoginerCollec.subLoginers,savingName);
    }
    public static void retrieve(){
        genericLoginerCollec.subLoginers=FileHelper.retrieve(genericLoginerCollec.subLoginers,savingName);
    }
}

