package com.example.egoverment;
import java.io.*;
import java.time.LocalDate;

public class MinistryOfElectricity {
    private static ElectricityBill currentBill;

    public MinistryOfElectricity() {
        currentBill = new ElectricityBill();
    }

    public static void displayBill() {
        System.out.println("Bill ID: " + currentBill.getBillID());
        System.out.println("Bill Amount: " + currentBill.getAmount());
        System.out.println("Bill Due Date: " + currentBill.getDueDate());
        System.out.println("Payment Status: " + (currentBill.isPaid() ? "Paid" : "Unpaid"));
    }

    public static void payBill() {
        if (currentBill.isPaid()) {
            System.out.println("The bill is already paid.");
        } else {
            currentBill.setPaid(true);
            System.out.println("The bill has been paid successfully!");
        }
    }

    public static String getCurrentBillDetails() {
        if (currentBill == null) {
            return "No current bill available.";
        }
        return "Amount: " + currentBill.getAmount() + "\n" +
                "Due Date: " + currentBill.getDueDate() + "\n" +
                "Status: " + (currentBill.isPaid() ? "Paid" : "Unpaid");
    }

    public static String payCurrentBill() {
        if (currentBill == null) {
            return "No bill available to pay.";
        }
        if (currentBill.isPaid()) {
            return "This bill is already paid.";
        }
        currentBill.setPaid(true);
        return "Payment successful for bill amount: " + currentBill.getAmount();
    }


}
