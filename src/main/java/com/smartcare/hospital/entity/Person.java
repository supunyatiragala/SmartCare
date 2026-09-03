package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "Person_ID", length = 20)
    private String personId;

    @Column(name = "Full_Name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "Gender", nullable = false)
    private String gender;

    @Column(name = "DOB", nullable = false)
    private LocalDate dob;

    @Column(name = "Contact_Number", length = 15)
    private String contactNumber;

    @Column(name = "Address")
    private String address;

}