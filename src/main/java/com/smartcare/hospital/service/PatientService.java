package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // 1. Register Patient
    public Patient registerPatient(Patient patient) {
        if (patient.getContactNumber() != null && !patient.getContactNumber().matches("\\d{10}")) {
            throw new RuntimeException("Contact number must be valid (10 digits)!");
        }
        return patientRepository.save(patient);
    }

    // 2. View All Patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // View Patient by ID
    public Patient getPatientById(String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    // 3. Update Patient Details
    public Patient updatePatient(String id, Patient patientDetails) {
        Patient existing = getPatientById(id);
        existing.setFullName(patientDetails.getFullName());
        existing.setGender(patientDetails.getGender());
        existing.setDob(patientDetails.getDob());
        existing.setContactNumber(patientDetails.getContactNumber());
        existing.setAddress(patientDetails.getAddress());
        existing.setBloodGroup(patientDetails.getBloodGroup());
        existing.setEmergencyContact(patientDetails.getEmergencyContact());

        return patientRepository.save(existing);
    }

    // 4. Delete Patient Record
    public void deletePatient(String id) {
        Patient existing = getPatientById(id);
        patientRepository.delete(existing);
    }

    // 5. Search Patients by Name
    public List<Patient> searchPatients(String query) {
        return patientRepository.findByFullNameContainingIgnoreCase(query);
    }
}