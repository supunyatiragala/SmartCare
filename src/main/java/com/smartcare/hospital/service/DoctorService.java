package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Department;
import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.repository.DepartmentRepository;
import com.smartcare.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // 1. Add Doctor
    public Doctor addDoctor(Doctor doctor) {
        if (doctor.getConsultationFee() == null || doctor.getConsultationFee() <= 0) {
            throw new RuntimeException("Consultation fee must be greater than zero!");
        }
        return doctorRepository.save(doctor);
    }

    // View All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // View Doctor by ID
    public Doctor getDoctorById(String id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    // 2. Update Doctor Details
    public Doctor updateDoctor(String id, Doctor doctorDetails) {
        Doctor existing = getDoctorById(id);

        if (doctorDetails.getConsultationFee() == null || doctorDetails.getConsultationFee() <= 0) {
            throw new RuntimeException("Consultation fee must be greater than zero!");
        }

        // Updated from setDoctorName to setFullName (Inherited from Person)
        existing.setFullName(doctorDetails.getFullName());
        existing.setSpecialization(doctorDetails.getSpecialization());
        existing.setQualification(doctorDetails.getQualification());
        existing.setContactNumber(doctorDetails.getContactNumber());
        existing.setConsultationFee(doctorDetails.getConsultationFee());

        if (doctorDetails.getDepartment() != null) {
            existing.setDepartment(doctorDetails.getDepartment());
        }

        return doctorRepository.save(existing);
    }

    // 3. Delete Doctor
    public void deleteDoctor(String id) {
        Doctor existing = getDoctorById(id);
        doctorRepository.delete(existing);
    }

    // 4. Search Doctors (Updated to match fullName from Person)
    public List<Doctor> searchDoctors(String query) {
        return doctorRepository.findByFullNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(query, query);
    }

    // 5. Assign Doctor to Department
    public Doctor assignDepartment(String doctorId, String departmentId) {
        Doctor doctor = getDoctorById(doctorId);
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));

        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }
}