package com.example.egoverment;


public class Loginer extends Human {

    private String loginName;
    private String Password;
    private String mail;
    public Loginer(String name, long id, String loginName, String password,String mail) {
        super(name, id);
        this.loginName = loginName;
        password=Hashing.hash(password);
        this.Password = password;
        this.mail=mail;
    }

    protected String getLoginName() {
        return loginName;
    }
    public String getMail() {
        return mail;
    }
    protected String getPassword() {
        return Password;
    }

    }







