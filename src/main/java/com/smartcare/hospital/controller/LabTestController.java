package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.LabTest;
import com.smartcare.hospital.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    // 1. Add Laboratory Test
    @PostMapping
    public ResponseEntity<LabTest> addLabTest(@RequestBody LabTest labTest) {
        return ResponseEntity.ok(labTestService.addLabTest(labTest));
    }

    // 2. Update Laboratory Result
    @PutMapping("/{id}/result")
    public ResponseEntity<LabTest> updateLabResult(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody) {
        String result = requestBody.get("result");
        String technicianName = requestBody.get("technicianName");
        return ResponseEntity.ok(labTestService.updateLabResult(id, result, technicianName));
    }

    // 3. View Laboratory History by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<LabTest>> getPatientLabHistory(@PathVariable String patientId) {
        return ResponseEntity.ok(labTestService.getPatientLabHistory(patientId));
    }

    // View All Lab Tests
    @GetMapping
    public ResponseEntity<List<LabTest>> getAllLabTests() {
        return ResponseEntity.ok(labTestService.getAllLabTests());
    }
}