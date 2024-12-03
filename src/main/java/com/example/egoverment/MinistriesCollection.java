package com.example.egoverment;
import java.util.ArrayList;

public class  MinistriesCollection {
    static int i=0;
    static ArrayList<Ministry> minis = new ArrayList<Ministry>();
    static{
        minis.add(new Ministry("Ministry of Interior",i++));
        minis.add(new Ministry("Ministry of Education",i++));
        minis.add(new Ministry("Ministry of Finance",i++));
        minis.add(new Ministry("Ministry of Transportation",i++));
        //minis.add(new MinistryOfElectricity("Ministry Electricity and Energy",i++));
        minis.add(new MinistryOfHealthAndPopulation("Ministry of Health and population",i++));
    };
    public static void add(String name){
        minis.add(new Ministry(name,i++));
    }

}
