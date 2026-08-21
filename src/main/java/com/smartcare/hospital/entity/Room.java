package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @Column(name = "Room_ID", length = 20)
    private String roomId;

    @Column(name = "Category", nullable = false)
    private String category;

    @Column(name = "Room_charge", nullable = false)
    private Double roomCharge;

    @Column(name = "Availability")
    private String availability = "Available";
}