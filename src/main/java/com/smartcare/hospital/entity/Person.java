package com.smartcare.hospital.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {

    private String fullName;
    private String contactNumber;

    public abstract String getDetails();
}