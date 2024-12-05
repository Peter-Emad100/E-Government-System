package com.example.egoverment;

public class OwnerCollection {
    private final static String savingName="owners";
    static GenericLoginerCollec<Owner> genericLoginerCollec=new GenericLoginerCollec<Owner>();
    public void add(String name, int id, String loginName, String hashedPassword){
        genericLoginerCollec.subLoginers.add(new Owner(name,id,loginName,hashedPassword));
    }
    public static void prepareToSave(){
        FileHelper.prepareToSave(genericLoginerCollec.subLoginers,savingName);
    }
    public static  void retrieve(){
        genericLoginerCollec.subLoginers=FileHelper.retrieve(genericLoginerCollec.subLoginers,savingName);
    }
}
