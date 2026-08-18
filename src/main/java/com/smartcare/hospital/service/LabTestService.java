package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.entity.LabTest;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.repository.DoctorRepository;
import com.smartcare.hospital.repository.LabTestRepository;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LabTestService {

    @Autowired
    private LabTestRepository labTestRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public LabTest addLabTest(LabTest labTest) {
        Patient patient = patientRepository.findById(labTest.getPatient().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(labTest.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        labTest.setPatient(patient);
        labTest.setDoctor(doctor);

        if (labTest.getTestDate() == null) {
            labTest.setTestDate(LocalDate.now());
        }
        if (labTest.getTestStatus() == null) {
            labTest.setTestStatus("Pending");
        }
        if (labTest.getTestResult() == null) {
            labTest.setTestResult("Pending");
        }

        return labTestRepository.save(labTest);
    }

    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }
}