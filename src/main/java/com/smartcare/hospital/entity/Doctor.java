package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @Column(name = "Doctor_ID")
    private String doctorId;

    @Column(name = "Doctor_Name", nullable = false)
    private String doctorName;

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "Qualification")
    private String qualification;

    @Column(name = "Contact_Number")
    private String contactNumber;

    @Column(name = "Consultation_Fee", nullable = false)
    private Double consultationFee;

    @ManyToOne
    @JoinColumn(name = "Department_ID")
    private Department department;
}