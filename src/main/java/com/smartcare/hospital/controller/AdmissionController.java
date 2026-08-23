package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    // Admit Patient
    @PostMapping("/admit")
    public ResponseEntity<Admission> admitPatient(@RequestBody Admission admission) {
        return ResponseEntity.ok(admissionService.admitPatient(admission));
    }

    // Discharge Patient
    @PutMapping("/{id}/discharge")
    public ResponseEntity<Admission> dischargePatient(@PathVariable String id) {
        return ResponseEntity.ok(admissionService.dischargePatient(id));
    }
}