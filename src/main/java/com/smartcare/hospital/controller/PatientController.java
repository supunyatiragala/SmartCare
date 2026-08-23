package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // 1. Register Patient
    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.registerPatient(patient));
    }

    // 2. View All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // View Patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    // 3. Update Patient Details
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patientDetails) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientDetails));
    }

    // 4. Delete Patient Record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient record deleted successfully!");
    }

    // 5. Search Patients
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam("query") String query) {
        return ResponseEntity.ok(patientService.searchPatients(query));
    }
}