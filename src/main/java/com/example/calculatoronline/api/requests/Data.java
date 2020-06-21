package com.example.calculatoronline.api.requests;

import java.time.LocalDate;

public class Data {
    private Integer creditAmount;
    private Double interestRate;
    private Integer quantityMonths;
    private LocalDate date;

    public Data() {
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getQuantityMonths() {
        return quantityMonths;
    }

    public void setQuantityMonths(int quantityMonths) {
        this.quantityMonths = quantityMonths;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
