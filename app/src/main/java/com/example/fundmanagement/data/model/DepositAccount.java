package com.example.fundmanagement.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DepositAccount {
    @SerializedName("accountNumber") private String accountNumber;
    @SerializedName("amount") private double amount;
    @SerializedName("tenure") private double tenure;
    @SerializedName("branch") private double branch;
    @SerializedName("date") private Date openingDate;
    @SerializedName("autoRenew") private boolean autoRenew;
    @SerializedName("autoRenewWithInterest") private boolean autoRenewWithInterest;
    @SerializedName("status") private Status status;
    enum Status {
        ACTIVE,
        INACTIVE,
        CLOSED,
        PENDING,
        SUSPENDED,
        MATURED
    }

    public DepositAccount(String accountNumber, double amount, double tenure, double branch, Date openingDate, Status status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.tenure = tenure;
        this.branch = branch;
        this.openingDate = openingDate;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTenure() {
        return tenure;
    }

    public void setTenure(double tenure) {
        this.tenure = tenure;
    }

    public double getBranch() {
        return branch;
    }

    public void setBranch(double branch) {
        this.branch = branch;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
