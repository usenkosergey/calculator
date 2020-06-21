package com.example.calculatoronline.api.responses;

import java.util.List;

public class Payments {
    private List<Payment> payment;

    public Payments() {
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}
