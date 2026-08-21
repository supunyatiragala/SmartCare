package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Admission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

    @Id
    @Column(name = "Admission_ID", length = 20)
    private String admissionId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    @Column(name = "Admission_Date", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "Discharge_Date")
    private LocalDate dischargeDate;

    @Column(name = "Admission_Status")
    private String admissionStatus = "Admitted";
}