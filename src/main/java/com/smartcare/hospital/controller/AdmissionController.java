package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping
    public ResponseEntity<Admission> admitPatient(@RequestBody Admission admission) {
        return ResponseEntity.ok(admissionService.admitPatient(admission));
    }

    @GetMapping
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        return ResponseEntity.ok(admissionService.getAllAdmissions());
    }
}