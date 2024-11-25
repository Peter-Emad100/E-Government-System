package com.example.egoverment;

public class ElectricityBill {
    private static int BillNo = 0;
    private static final double DEFAULT_BILL_AMOUNT = 850.00;
    private boolean isPaid;
    private final int billID;
    //    private String dateIssued;
    private String datePaid;
    private String dueDate;
    private double amount;

    public ElectricityBill(double amount, String dueDate) {
        BillNo += 1;
        this.amount = DEFAULT_BILL_AMOUNT;
        isPaid = false;
        this.dueDate = dueDate;
        billID = BillNo;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getBillID() {
        return billID;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }
}
