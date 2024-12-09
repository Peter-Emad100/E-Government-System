package com.example.egoverment;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileHelper {
    private final static String path="json.json";
    private static String  jsonString=new String();
    private static Gson gson= new GsonBuilder().setPrettyPrinting().create();
    private static JsonObject jsonObject = new JsonObject();
    public static<T> void prepareToSave(ArrayList<T> arrayToSave, String arrayName ){
        JsonArray JsonArray = gson.toJsonTree(arrayToSave).getAsJsonArray();
        jsonObject.add(arrayName, JsonArray);

    }
    public static void prepareToSave(int number,String name){
        JsonElement jsonElement=gson.toJsonTree(number);
        jsonObject.add(name,jsonElement);
    }
    private static void save(){
        jsonString = gson.toJson(jsonObject);
        try (FileWriter fileWriter = new FileWriter(FileHelper.path)) {
            fileWriter.write(jsonString);
            System.out.println("JSON data saved");
        } catch (Exception e) {
            System.err.println("Error while saving JSON to file: " + e.getMessage());
        }
    }
    public static int retrieve(String keyName) {
        try (JsonReader reader = new JsonReader(new FileReader(FileHelper.path))) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            if (jsonObject.has(keyName)) {
                return jsonObject.get(keyName).getAsInt();
            } else {
                throw new IllegalArgumentException("Key '" + keyName + "' not found in JSON.");
            }
        } catch (IOException e) {
            System.out.println("Failed to read JSON: " + e.getMessage());
            return 0; // Default value in case of failure
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0; // Default value for missing key
        }
    }
    public static<T> ArrayList<T> retrieve(ArrayList<T> arrayToRetrieve, String arrayName,Class classOfT) {
        try (JsonReader reader = new JsonReader(new FileReader(FileHelper.path))) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray(arrayName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type listType = TypeToken.getParameterized(ArrayList.class, classOfT).getType();
             arrayToRetrieve = gson.fromJson(jsonArray, listType);
             return arrayToRetrieve;
        } catch (IOException e) {
            System.out.println("Failed to read JSON");
            return null;
        }
    }
    public static void saveAll() {
        MinistriesCollection.prepareMinistriesToSave();
        RequestCollection.prepareRequestsToSave();
        OwnerCollection.prepareOwnersToSave();
        UserCollection.prepareUsersToSave();
        FileHelper.prepareToSave(User.numberOfUsers,"NumberOfUsers");
        FileHelper.prepareToSave(Ministry.numberOfMinistries,"NumberOfMinistries");
        save();
    }
    public static void retrieveAll(){
        MinistriesCollection.retrieve();
        RequestCollection.retrieve();
        OwnerCollection.retrieve();
        UserCollection.retrieve();
        User.numberOfUsers=FileHelper.retrieve("NumberOfUsers");
        Ministry.numberOfMinistries=FileHelper.retrieve("NumberOfMinistries");
    }
}

