package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    // 1. Generate Bill (Calculates total charges automatically)
    public Bill generateBill(Bill bill) {
        if (bill.getConsultationCharge() < 0 || bill.getRoomCharge() < 0 ||
                bill.getLabCharge() < 0 || bill.getMedicineCharge() < 0) {
            throw new RuntimeException("Bill charges cannot be negative!");
        }

        // Calculate Total Amount
        double total = bill.getConsultationCharge() + bill.getRoomCharge() +
                bill.getLabCharge() + bill.getMedicineCharge();

        bill.setTotalAmount(total);

        if (bill.getBillDate() == null) {
            bill.setBillDate(LocalDate.now());
        }

        if (bill.getPaymentStatus() == null) {
            bill.setPaymentStatus("UNPAID");
        }

        return billRepository.save(bill);
    }

    // 2. Process Payment
    public Bill processPayment(Long billId, String paymentMethod) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found with ID: " + billId));

        bill.setPaymentStatus("PAID");
        bill.setPaymentMethod(paymentMethod);

        return billRepository.save(bill);
    }

    // 3. Get Bills by Patient ID
    public List<Bill> getBillsByPatient(String patientId) {
        return billRepository.findByPatientPersonId(patientId);
    }

    // Get All Bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}