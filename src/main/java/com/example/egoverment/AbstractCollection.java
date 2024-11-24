package com.example.egoverment;

import java.util.ArrayList;
public abstract class AbstractCollection<T extends Loginer> {
    protected ArrayList<T> subLoginers= new ArrayList<T>();

    public T searchForLogin(String name, String Password) {
        for (T subLoginer : subLoginers) {
            if (subLoginer.getLoginName().equals(name)) {
                if (subLoginer.getPassword().equals(Password)) {
                    return subLoginer;
                } else {
                    return null;
                }
            }

        }
        return null;
    }
    public T idSearch(String id) {
        for (T subLoginer : subLoginers) {
            if (subLoginer.getId().equals(id)) {
                return subLoginer;
            }
        }
        return null;
    }

}
