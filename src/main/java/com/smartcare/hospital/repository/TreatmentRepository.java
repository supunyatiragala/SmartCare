package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    List<Treatment> findByPatientPersonIdOrderByTreatmentDateDesc(String patientId);
}