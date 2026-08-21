package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Treatment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {

    @Id
    @Column(name = "Treatment_ID", length = 20)
    private String treatmentId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Doctor_ID")
    private Doctor doctor;

    @Column(name = "Treatment_Details")
    private String treatmentDetails;

    @Column(name = "Treatment_Date", nullable = false)
    private LocalDate treatmentDate;
}