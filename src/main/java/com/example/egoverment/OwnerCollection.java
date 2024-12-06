package com.example.egoverment;

public class OwnerCollection {
    private final static String savingName="owners";
    static GenericLoginerCollec<Owner> genericLoginerCollec=new GenericLoginerCollec<Owner>();
    public void add(String name, int id, String loginName, String hashedPassword,String mail){
        genericLoginerCollec.subLoginers.add(new Owner(name,id,loginName,hashedPassword,mail));
    }
    public static void prepareToSave(){
        FileHelper.prepareToSave(genericLoginerCollec.subLoginers,savingName);
    }
    public static  void retrieve(){
        genericLoginerCollec.subLoginers=FileHelper.retrieve(genericLoginerCollec.subLoginers,savingName ,Owner.class);
    }
    public static boolean search(String mail , String password){
        return genericLoginerCollec.searchForLogin(mail,password);
    }
}
