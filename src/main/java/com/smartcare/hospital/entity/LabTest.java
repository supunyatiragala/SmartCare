package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "lab_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "test_name", nullable = false)
    private String testName;

    @Column(name = "test_cost", nullable = false)
    private Double testCost;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @Column(name = "result", columnDefinition = "TEXT")
    private String result;

    @Column(name = "technician_name")
    private String technicianName;

    @Column(name = "status")
    private String status = "PENDING";
}