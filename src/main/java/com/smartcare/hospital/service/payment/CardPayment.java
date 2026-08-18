package com.smartcare.hospital.service.payment;

import org.springframework.stereotype.Component;

@Component("CARD")
public class CardPayment implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Paid LKR " + amount + " via Credit/Debit Card.";
    }
}