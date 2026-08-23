package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {

    List<LabTest> findByPatientPersonIdOrderByTestDateDesc(String patientId);
}