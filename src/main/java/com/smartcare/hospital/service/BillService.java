package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill createBill(Bill bill) {
        // 1. Validation: Bill amount check
        if (bill.getTotalAmount() == null || bill.getTotalAmount() < 0) {
            throw new RuntimeException("Bill amount cannot be negative!");
        }

        // 2. Default Values Set කිරීම
        if (bill.getBillDate() == null) {
            bill.setBillDate(LocalDateTime.now());
        }
        if (bill.getPaymentStatus() == null) {
            bill.setPaymentStatus("UNPAID");
        }

        return billRepository.save(bill);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with ID: " + id));
    }
}