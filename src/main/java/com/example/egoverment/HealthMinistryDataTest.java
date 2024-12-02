package com.example.egoverment;

import java.util.Arrays;

public class HealthMinistryDataTest {
    public static MinistryOfHealthAndPopulation initializeHealthMinistry() {

        MinistryOfHealthAndPopulation healthMinistry = new MinistryOfHealthAndPopulation("Ministry of Health And Population", 77);


        BloodBag bag1 = new BloodBag(BloodType.A_POS, 10);
        BloodBag bag2 = new BloodBag(BloodType.B_NEG, 5);
        BloodBag bag3 = new BloodBag(BloodType.O_NEG, 7);
        BloodBag bag4 = new BloodBag(BloodType.A_NEG, 4);
        BloodBag bag5 = new BloodBag(BloodType.A_POS, 8);

        BloodBank bank1 = new BloodBank("Abbasyia BloodBank", Arrays.asList(bag1, bag2));
        BloodBank bank2 = new BloodBank("Nasr City Hospital", Arrays.asList(bag3, bag5));
        BloodBank bank3 = new BloodBank("Al Mohandeseen Clinic", Arrays.asList(bag4));

        healthMinistry.addBloodBank(bank1.getLocation(), bank1.getAvailableBloodBags());
        healthMinistry.addBloodBank(bank2.getLocation(), bank2.getAvailableBloodBags());
        healthMinistry.addBloodBank(bank3.getLocation(), bank3.getAvailableBloodBags());

        return healthMinistry;
    }
}
