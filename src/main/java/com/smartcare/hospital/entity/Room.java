package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", unique = true, nullable = false)
    private String roomNumber;

    @Column(name = "bed_number", nullable = false)
    private String bedNumber;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "daily_rate", nullable = false)
    private Double dailyRate;
}