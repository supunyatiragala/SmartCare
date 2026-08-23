package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    // 1. Record Diagnosis & Prescribe Treatment
    public Treatment recordTreatment(Treatment treatment) {
        if (treatment.getDiagnosis() == null || treatment.getDiagnosis().trim().isEmpty()) {
            throw new RuntimeException("Diagnosis details are required!");
        }
        if (treatment.getPrescription() == null || treatment.getPrescription().trim().isEmpty()) {
            throw new RuntimeException("Prescription details are required!");
        }

        if (treatment.getTreatmentDate() == null) {
            treatment.setTreatmentDate(LocalDateTime.now());
        }

        return treatmentRepository.save(treatment);
    }

    // 2. Maintain & View Patient Medical History
    public List<Treatment> getPatientMedicalHistory(String patientId) {
        return treatmentRepository.findByPatientPersonIdOrderByTreatmentDateDesc(patientId);
    }

    // View All Treatments
    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }
}