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

    @Column(name = "Specialization", length = 100)
    private String specialization;

    @Column(name = "Contact_Number", length = 15)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "Department_ID")
    private Department department;
}