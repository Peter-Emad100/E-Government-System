package com.example.egoverment;

import java.util.ArrayList;

public class GenericLoginerCollec<T extends Loginer> {
    protected ArrayList<T> subLoginers= new ArrayList<T>();

    public boolean searchForLogin(String mail, String Password) {
        for (T subLoginer : subLoginers) {
            if (subLoginer.getMail().equals(mail)) {
                return subLoginer.getPassword().equals(Password);
            }

        }
        return false;
    }
    public T idSearch(int id) {
        for (T subLoginer : subLoginers) {
            if (subLoginer.getId() == id) {
                return subLoginer;
            }
        }
        return null;
    }
}