package com.example.parking.service;

import com.example.parking.model.ParkingSlot;
import com.example.parking.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ParkingService {

    @Autowired
    private ParkingSlotRepository repository;

    public ParkingSlot assignSlot(String vehicleNumber) {
        return repository.findByIsOccupiedFalse().stream()
                .findFirst()
                .map(slot -> {
                    slot.setOccupied(true);
                    slot.setVehicleNumber(vehicleNumber);
                    slot.setEntryTime(LocalDateTime.now());
                    return repository.save(slot);
                })
                .orElseThrow(() -> new RuntimeException("No available slots!"));
    }

    public ParkingSlot releaseSlot(String vehicleNumber) {
        ParkingSlot slot = repository.findByVehicleNumber(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found!"));
        slot.setOccupied(false);
        slot.setVehicleNumber(null);
        slot.setEntryTime(null);
        return repository.save(slot);
    }
}