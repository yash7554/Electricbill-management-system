package com.example.parking.repository;

import com.example.parking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
    List<ParkingSlot> findByIsOccupiedFalse();
    Optional<ParkingSlot> findByVehicleNumber(String vehicleNumber);
}