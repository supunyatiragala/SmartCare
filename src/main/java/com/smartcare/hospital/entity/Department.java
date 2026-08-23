package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "Department_ID")
    private String departmentId;

    @Column(name = "Department_Name", nullable = false)
    private String departmentName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Head_Doctor")
    private String headDoctor;
}