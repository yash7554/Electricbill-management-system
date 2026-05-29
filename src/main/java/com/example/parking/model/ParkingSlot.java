package com.example.parking.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String slotNumber;

    private boolean isOccupied;
    private String vehicleNumber;
    private LocalDateTime entryTime;
}