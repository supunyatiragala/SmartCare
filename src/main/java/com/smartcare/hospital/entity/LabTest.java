package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "labtest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_test_id")
    private Long labTestId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_date")
    private LocalDate testDate;

    @Column(name = "test_result")
    private String testResult;

    @Column(name = "technician_name")
    private String technicianName;

    @Column(name = "test_status")
    private String testStatus;
}