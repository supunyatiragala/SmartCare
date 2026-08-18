package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String gender;
    private String address;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    // Person Class එකේ Method එක Override කිරීම (Polymorphism)
    @Override
    public String getDetails() {
        return "Patient Name: " + getFullName() + " | Blood Group: " + bloodGroup;
    }
}