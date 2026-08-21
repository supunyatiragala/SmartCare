package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Long id වෙනුවට String id යොදන්න
    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }
}