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
    @Column(name = "Doctor_ID", length = 20)
    private String doctorId;

    @Column(name = "Doctor_Name", nullable = false, length = 100)
    private String doctorName;

    @Column(name = "Specialization", nullable = false, length = 100)
    private String specialization;

    @Column(name = "Qualification", length = 100)
    private String qualification;

    // precision සහ scale ඉවත් කර ඇත
    @Column(name = "Consultation_fee")
    private Double consultationFee;

    @ManyToOne
    @JoinColumn(name = "Department_ID")
    private Department department;
}