package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Doctor")
@PrimaryKeyJoinColumn(name = "Doctor_ID")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "Qualification")
    private String qualification;

    @Column(name = "Consultation_Fee", nullable = false)
    private Double consultationFee;

    @ManyToOne
    @JoinColumn(name = "Department_ID")
    private Department department;
}