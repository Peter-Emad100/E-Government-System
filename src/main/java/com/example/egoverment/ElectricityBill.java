package com.example.egoverment;

import java.time.LocalDate;
import java.time.YearMonth;

public class ElectricityBill {
    private static int BillNo = 0;
    private static final double DEFAULT_BILL_AMOUNT = 850.00;

    private boolean isPaid;
    private final int billID;
    private final LocalDate dueDate;
    private final double amount;

    public ElectricityBill() {
        BillNo += 1; // counts the number of bills made
        this.amount = DEFAULT_BILL_AMOUNT;
        this.isPaid = false;
        this.dueDate = calculateDueDate();
        this.billID = BillNo; // adds a unique ID to each bill
    }

    public double getAmount() {
        return amount;
    }

    public int getBillID() {
        return billID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    // gets the end of the current month
    private LocalDate calculateDueDate() {
        YearMonth currentMonth = YearMonth.now(); // gets the current month
        return currentMonth.atEndOfMonth(); // gets the last day of the month
    }
}
