package com.smartcare.hospital.service.payment;

public interface PaymentProcessor {
    String processPayment(double amount);
}