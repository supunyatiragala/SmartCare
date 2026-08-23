package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_date")
    private LocalDateTime billDate;

    @Column(name = "consultation_charge")
    private Double consultationCharge = 0.0;

    @Column(name = "room_charge")
    private Double roomCharge = 0.0;

    @Column(name = "lab_charge")
    private Double labCharge = 0.0;

    @Column(name = "medicine_charge")
    private Double medicineCharge = 0.0;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "payment_status")
    private String paymentStatus = "UNPAID";

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}