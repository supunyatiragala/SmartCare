package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @Column(name = "Bill_ID", length = 20)
    private String billId;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @Column(name = "Bill_Date", nullable = false)
    private LocalDate billDate;

    @Column(name = "Total_Amount", nullable = false)
    private Double totalAmount;

    @Column(name = "Payment_Status")
    private String paymentStatus = "Unpaid";

    // Database එකේ save නොවන, Postman Payment Strategy සඳහා පමණක් භාවිත වන field එකක්
    @Transient
    private String paymentMethod;
}