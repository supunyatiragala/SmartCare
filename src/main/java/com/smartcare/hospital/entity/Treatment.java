package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "treatment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private Long treatmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String diagnosis;

    @Column(name = "prescription_details")
    private String prescriptionDetails;

    @Column(name = "treatment_notes")
    private String treatmentNotes;

    @Column(name = "treatment_date")
    private LocalDate treatmentDate;
}