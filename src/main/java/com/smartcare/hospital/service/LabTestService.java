package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.LabTest;
import com.smartcare.hospital.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    // 1. Add Laboratory Test
    public LabTest addLabTest(LabTest labTest) {
        if (labTest.getTestName() == null || labTest.getTestName().trim().isEmpty()) {
            throw new RuntimeException("Test name is required!");
        }
        if (labTest.getTestCost() == null || labTest.getTestCost() <= 0) {
            throw new RuntimeException("Test cost must be greater than zero!");
        }
        if (labTest.getTestDate() == null) {
            labTest.setTestDate(LocalDate.now());
        }
        if (labTest.getStatus() == null) {
            labTest.setStatus("PENDING");
        }
        return labTestRepository.save(labTest);
    }

    // 2. Update Laboratory Results
    public LabTest updateLabResult(Long id, String result, String technicianName) {
        LabTest labTest = labTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lab test record not found with ID: " + id));

        labTest.setResult(result);
        labTest.setTechnicianName(technicianName);
        labTest.setStatus("COMPLETED");

        return labTestRepository.save(labTest);
    }

    // 3. View Laboratory History by Patient
    public List<LabTest> getPatientLabHistory(String patientId) {
        return labTestRepository.findByPatientPersonIdOrderByTestDateDesc(patientId);
    }

    // View All Lab Tests
    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }
}