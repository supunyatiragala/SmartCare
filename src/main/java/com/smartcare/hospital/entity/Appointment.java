package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @Column(name = "Appointment_ID", length = 20)
    private String appointmentId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    @Column(name = "Appointment_Date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "Appointment_Time", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "Consultation_Room", length = 20)
    private String consultationRoom;

    @Column(name = "Appointment_Status")
    private String appointmentStatus = "Occupied";
}