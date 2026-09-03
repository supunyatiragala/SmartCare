package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    // Updated from findByDoctorName to findByFullName
    List<Doctor> findByFullNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(String name, String specialization);
}