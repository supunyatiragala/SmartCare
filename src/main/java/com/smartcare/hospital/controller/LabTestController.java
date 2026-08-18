package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.LabTest;
import com.smartcare.hospital.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labtests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    @PostMapping
    public ResponseEntity<LabTest> addLabTest(@RequestBody LabTest labTest) {
        return ResponseEntity.ok(labTestService.addLabTest(labTest));
    }

    @GetMapping
    public ResponseEntity<List<LabTest>> getAllLabTests() {
        return ResponseEntity.ok(labTestService.getAllLabTests());
    }
}