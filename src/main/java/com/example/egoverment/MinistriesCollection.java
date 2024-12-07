package com.example.egoverment;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
public class  MinistriesCollection {
    private static int i = 0;
    private final static String savingName="ministries";
    private static ArrayList<Ministry> minis = new ArrayList<Ministry>();

    /*static{
        minis.add(new Ministry("Ministry of Interior",i++));
        minis.add(new Ministry("Ministry of Education",i++));
        minis.add(new Ministry("Ministry of Finance",i++));
        minis.add(new Ministry("Ministry of Transportation",i++));
        //minis.add(new MinistryOfElectricity("Ministry Electricity and Energy",i++));
        minis.add(new MinistryOfHealthAndPopulation("Ministry of Health and population",i++));

    };*/
    /*private static ArrayList<Department> dep =new ArrayList<>();
    static {
        dep.add(new Department("department of national budget"));
        dep.add(new Department("department of treasury operations"));
        dep.add(new Department("department of information technology management"));

    }
    public static Department findDepartmentByName(String name) {
        for (Department departments : dep) {
            if (departments.getDepartmentName ().equalsIgnoreCase(name)) {
                return departments;
            }
        }
        return null;
    }*/

    public static void add (String name){
        minis.add(new Ministry(name));
    }

    public static void remove(Ministry ministryToRemove) {
        minis.remove(ministryToRemove); // Directly remove the object
    }

    public static void edit(String oldName, String newName) {
        for (Ministry ministry : minis) {
            if (ministry.getMinistryName().equalsIgnoreCase(oldName)) {
                ministry.setMinistryName(newName);
                return;
            }
        }
    }
    public static void prepareToSave () {
        FileHelper.prepareToSave(minis, savingName);
    }
    public static void retrieve () {
        minis = FileHelper.retrieve(minis, savingName, Ministry.class);
    }
    public static ArrayList<Ministry> getMinistries () {
        return minis;

    }
}
