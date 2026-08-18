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

    @PostMapping
    public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.addTreatment(treatment));
    }

    @GetMapping
    public ResponseEntity<List<Treatment>> getAllTreatments() {
        return ResponseEntity.ok(treatmentService.getAllTreatments());
    }
}