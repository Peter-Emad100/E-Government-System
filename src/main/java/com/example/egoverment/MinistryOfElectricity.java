package com.example.egoverment;
import java.io.*;
import java.time.LocalDate;

public class MinistryOfElectricity {
    private int paidCount = 0;
    private ElectricityBill currentBill;

    public MinistryOfElectricity() {
        this.currentBill = new ElectricityBill();
    }

    public void displayBill() {
        System.out.println("Bill ID: " + currentBill.getBillID());
        System.out.println("Bill Amount: " + currentBill.getAmount());
        System.out.println("Bill Due Date: " + currentBill.getDueDate());
        System.out.println("Payment Status: " + (currentBill.isPaid() ? "Paid" : "Unpaid"));
    }

    public void payBill() {
        if (currentBill.isPaid()) {
            System.out.println("The bill is already paid.");
        } else {
            currentBill.setPaid(true);
            paidCount++;
            System.out.println("The bill has been paid successfully!");
        }
    }

    public String getCurrentBillDetails() {
        if (currentBill == null) {
            return "No current bill available.";
        }
        return "Amount: " + currentBill.getAmount() + "\n" +
                "Due Date: " + currentBill.getDueDate() + "\n" +
                "Status: " + (currentBill.isPaid() ? "Paid" : "Unpaid");
    }

    public String payCurrentBill() {
        if (currentBill == null) {
            return "No bill available to pay.";
        }
        if (currentBill.isPaid()) {
            return "This bill is already paid.";
        }
        currentBill.setPaid(true);
        return "Payment successful for bill amount: " + currentBill.getAmount();
    }

    public void loadBill(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double amount = Double.parseDouble(reader.readLine());
            String dueDate = reader.readLine();
            boolean isPaid = Boolean.parseBoolean(reader.readLine());

            currentBill = new ElectricityBill();
            currentBill.setPaid(isPaid);

            System.out.println("Bill loaded successfully from " + fileName);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading bill: " + e.getMessage());
        }
    }

    public void saveBillToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(currentBill.getAmount() + "\n");
            writer.write(currentBill.getDueDate() + "\n");
            writer.write(currentBill.isPaid() + "\n");
            System.out.println("Bill saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }
}
