package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    private String qualification;
    private String specialization;

    @Column(name = "consultation_fee")
    private Double consultationFee;

    // Person class එකෙන් එන Abstract Method එක Override කිරීම (Polymorphism)
    @Override
    public String getDetails() {
        return "Doctor: " + getFullName() + " | Specialization: " + specialization;
    }
}