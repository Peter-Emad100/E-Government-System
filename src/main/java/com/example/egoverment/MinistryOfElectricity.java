package com.example.egoverment;

import java.io.*;
import java.time.LocalDate;

public class MinistryOfElectricity {
    private int paidCount = 0;
    private ElectricityBill currentBill;

    public MinistryOfElectricity() {
        this.currentBill = new ElectricityBill(850.00, "01/12/2024");
    }

    public void displayBill() {
        System.out.println("Bill ID: " + currentBill.getBillID());
        System.out.println("Bill Amount: " + currentBill.getAmount());
        System.out.println("Bill Due Date: " + currentBill.getDueDate());

        if (currentBill.isPaid()) {
            System.out.println("Payment Status: Paid");
        } else {
            System.out.println("Payment Status: Unpaid");
        }
    }

    public void payBill() {
        if (currentBill.isPaid()) {
            System.out.println("The bill is already paid.");
        } else {
            currentBill.setPaid(true);
            currentBill.setDatePaid(LocalDate.now().toString()); // Set current date
            paidCount++;
            System.out.println("The bill has been paid!");
        }
    }

    public void loadBill(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double amount = Double.parseDouble(reader.readLine());
            String dueDate = reader.readLine();
            boolean isPaid = Boolean.parseBoolean(reader.readLine());
            String datePaid = reader.readLine();
            currentBill = new ElectricityBill(amount, dueDate);
            currentBill.setPaid(isPaid);
            currentBill.setDatePaid(datePaid.equals("Not Paid") ? null : datePaid);
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
            writer.write((currentBill.getDatePaid() != null ? currentBill.getDatePaid() : "Not Paid") + "\n");
            System.out.println("Bill saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }
}
