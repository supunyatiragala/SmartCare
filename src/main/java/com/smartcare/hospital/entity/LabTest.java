package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Laboratory_Test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTest {

    @Id
    @Column(name = "Lab_Test_ID", length = 20)
    private String labTestId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Doctor_ID")
    private Doctor doctor;

    @Column(name = "Test_Name", nullable = false, length = 100)
    private String testName;

    @Column(name = "Test_Date", nullable = false)
    private LocalDate testDate;

    @Column(name = "Test_Result")
    private String testResult;

    @Column(name = "Test_Status")
    private String testStatus = "Pending";
}