package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Column(name = "consultation_charge", nullable = false)
    private Double consultationCharge = 0.0;

    @Column(name = "room_charge", nullable = false)
    private Double roomCharge = 0.0;

    @Column(name = "lab_charge", nullable = false)
    private Double labCharge = 0.0;

    @Column(name = "medicine_charge", nullable = false)
    private Double medicineCharge = 0.0;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "payment_status")
    private String paymentStatus = "UNPAID";

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "bill_date")
    private LocalDate billDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}