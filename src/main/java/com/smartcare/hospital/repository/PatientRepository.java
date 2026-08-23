package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findByFullNameContainingIgnoreCase(String fullName);
}