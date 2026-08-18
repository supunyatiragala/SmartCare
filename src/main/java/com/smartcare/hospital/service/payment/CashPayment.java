package com.smartcare.hospital.service.payment;

import org.springframework.stereotype.Component;

@Component("CASH")
public class CashPayment implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Paid LKR " + amount + " via Cash.";
    }
}