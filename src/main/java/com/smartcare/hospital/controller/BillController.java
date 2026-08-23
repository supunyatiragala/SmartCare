package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // 1. Generate Bill
    @PostMapping
    public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.generateBill(bill));
    }

    // 2. Process Payment
    @PutMapping("/{id}/pay")
    public ResponseEntity<Bill> processPayment(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody) {
        String paymentMethod = requestBody.getOrDefault("paymentMethod", "CASH");
        return ResponseEntity.ok(billService.processPayment(id, paymentMethod));
    }

    // 3. View Bills by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getBillsByPatient(@PathVariable String patientId) {
        return ResponseEntity.ok(billService.getBillsByPatient(patientId));
    }

    // View All Bills
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }
}