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

    public static List<String> searchBloodBanks(BloodType bloodType, int requiredQuantity) {
        List<String> matchingBanks = new ArrayList<>();
        int totalAvailableQuantity = 0;

        for (BloodBank bloodBank : bloodBanks) {
            int bankQuantity = 0;
            for (BloodBag bloodBag : bloodBank.getAvailableBloodBags()) {
                if (bloodBag.getBloodType() == bloodType) {
                    bankQuantity += bloodBag.getQuantity();
                }
            }

            if (bankQuantity >= requiredQuantity) {
                matchingBanks.add("Bank: " + bloodBank.getLocation() + ", Available: " + bankQuantity + " bags. ");
                return matchingBanks;
            }

            if (bankQuantity > 0) {
                totalAvailableQuantity += bankQuantity;
                matchingBanks.add("Bank: " + bloodBank.getLocation() + ", Available: " + bankQuantity + " bags");
            }
        }

        if (totalAvailableQuantity >= requiredQuantity) {
            matchingBanks.add("Total Available: " + totalAvailableQuantity + " bags. You can take from these banks.");
        } else {
            StringBuilder insufficientMessage = new StringBuilder("Insufficient stock. Total Available: " + totalAvailableQuantity + " bags.\nBlood banks with available stock:\n");
            for (String bankInfo : matchingBanks) {
                insufficientMessage.append("- ").append(bankInfo).append("\n");
            }
            matchingBanks.clear();
            matchingBanks.add(insufficientMessage.toString());
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
