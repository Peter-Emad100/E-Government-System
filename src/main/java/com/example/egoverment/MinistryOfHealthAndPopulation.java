package com.example.egoverment;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MinistryOfHealthAndPopulation extends Ministry
{
    private List<BloodBank> bloodBanks;
    public MinistryOfHealthAndPopulation(String name)
    {
        super(name);
        super.departments=new ArrayList<>();
        super.addDepartmentsToMinistry("Department of Blood Banks");
        super.departments.get(0).addFormtoDepartment("Search For Blood Banks");
        this.bloodBanks = new ArrayList<>();
    }
    public void addBloodBank(String location, List<BloodBag> bloodBags) {
        bloodBanks.add(new BloodBank(location, bloodBags));
    }

    public List<BloodBank> searchBloodBanks(BloodType bloodType, int requiredQuantity) {
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






}
