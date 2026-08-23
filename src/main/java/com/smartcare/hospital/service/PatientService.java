package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        // 1. Validation: Patient Name check
        if (patient.getFullName() == null || patient.getFullName().trim().isEmpty()) {
            throw new RuntimeException("Patient name cannot be empty!");
        }

        // 2. Validation: Contact Number check (10 digits)
        if (patient.getContactNumber() == null || !patient.getContactNumber().matches("^\\d{10}$")) {
            throw new RuntimeException("Contact number must be valid (10 digits)!");
        }

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}