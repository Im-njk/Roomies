package com.Njk.roomies.model;

public class roomateDetail {
    String name;
    double Amount;
    boolean status;

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public roomateDetail(String name, double amount) {
        this.name = name;
        Amount = amount;
        status = false;
    }
}
