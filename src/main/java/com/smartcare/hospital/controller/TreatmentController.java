package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    // 1. Record Diagnosis & Treatment
    @PostMapping
    public ResponseEntity<Treatment> recordTreatment(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.recordTreatment(treatment));
    }

    // 2. View Patient Medical History
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Treatment>> getPatientMedicalHistory(@PathVariable String patientId) {
        return ResponseEntity.ok(treatmentService.getPatientMedicalHistory(patientId));
    }

    // View All Treatments
    @GetMapping
    public ResponseEntity<List<Treatment>> getAllTreatments() {
        return ResponseEntity.ok(treatmentService.getAllTreatments());
    }
}