package com.example.calculatoronline.api.responses;

import java.time.LocalDate;

public class Payment {
    private Integer numberPayment;
    private String monthlyPayment;
    private String percentMonths;
    private String debt;
    private String balanceAmount;
    private LocalDate datePayment;

    public Payment() {
    }

    public Integer getNumberPayment() {
        return numberPayment;
    }

    public void setNumberPayment(Integer numberPayment) {
        this.numberPayment = numberPayment;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPercentMonths() {
        return percentMonths;
    }

    public void setPercentMonths(String percentMonths) {
        this.percentMonths = percentMonths;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public LocalDate getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDate datePayment) {
        this.datePayment = datePayment;
    }
}
