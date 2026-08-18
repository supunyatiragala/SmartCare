package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.BillRepository;
import com.smartcare.hospital.repository.PatientRepository;
import com.smartcare.hospital.service.payment.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Map<String, PaymentProcessor> paymentProcessors;

    public Bill createBill(Bill bill) {
        Patient patient = patientRepository.findById(bill.getPatient().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        bill.setPatient(patient);

        if (bill.getBillDate() == null) {
            bill.setBillDate(LocalDate.now());
        }

        if (bill.getPaymentMethod() != null) {
            String methodKey = bill.getPaymentMethod().toUpperCase();
            PaymentProcessor processor = paymentProcessors.get(methodKey);

            if (processor != null) {
                processor.processPayment(bill.getTotalAmount());
                bill.setPaymentStatus("Paid");
            }
        }

        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}