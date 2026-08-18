package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.repository.DoctorRepository;
import com.smartcare.hospital.repository.PatientRepository;
import com.smartcare.hospital.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Treatment addTreatment(Treatment treatment) {
        Patient patient = patientRepository.findById(treatment.getPatient().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(treatment.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        treatment.setPatient(patient);
        treatment.setDoctor(doctor);

        if (treatment.getTreatmentDate() == null) {
            treatment.setTreatmentDate(LocalDate.now());
        }

        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }
}