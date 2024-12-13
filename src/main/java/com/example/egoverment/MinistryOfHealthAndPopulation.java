package com.example.egoverment;

import java.util.List;
import java.util.ArrayList;

public class MinistryOfHealthAndPopulation {
    private String name;
    private static List<BloodBank> bloodBanks;

    public MinistryOfHealthAndPopulation(String name) {
        this.name = name;
        this.bloodBanks = new ArrayList<>();
    }

    public void addBloodBank(String location, List<BloodBag> bloodBags) {
        bloodBanks.add(new BloodBank(location, bloodBags));
    }

    public static List<BloodBank>  searchBloodBanks(BloodType bloodType, int requiredQuantity) {
        List<BloodBank> matchingBanks = new ArrayList<>();

        for (BloodBank bloodBank : bloodBanks) {
            for (BloodBag bloodBag : bloodBank.getAvailableBloodBags()) {
                if (bloodBag.getBloodType() == bloodType && bloodBag.getQuantity() >= requiredQuantity) {
                    matchingBanks.add(bloodBank);
                    break;
                }
            }
        }

        return matchingBanks;
    }

    public List<BloodBank> getBloodBanks() {
        return bloodBanks;
    }

    public String getName() {
        return name;
    }
}
