package com.smartcare.hospital.service.payment;

import org.springframework.stereotype.Component;

@Component("ONLINE")
public class OnlinePayment implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Paid LKR " + amount + " via Online Bank Transfer / Gateway.";
    }
}