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

    public static void add (String name){
        minis.add(new Ministry(name));
    }

    public static void remove(Ministry ministryToRemove) {
        minis.remove(ministryToRemove); // Directly remove the object
        Ministry.numberOfMinistries--;  // update no. of ministries
    }

    public static void edit(String oldName, String newName) {
        for (Ministry ministry : minis) {
            if (ministry.getMinistryName().equalsIgnoreCase(oldName)) {
                ministry.setMinistryName(newName);
                return;
            }
        }
    }
    public static void prepareMinistriesToSave () {
        FileHelper.prepareToSave(minis, savingName);
    }
    public static void retrieve () {
        minis = FileHelper.retrieve(minis, savingName, Ministry.class);
    }
    public static ArrayList<Ministry> getMinistries () {
        return minis;

    }
}
