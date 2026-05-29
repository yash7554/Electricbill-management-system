package com.example.parking.controller;

import com.example.parking.model.ParkingSlot;
import com.example.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService service;

    @PostMapping("/park")
    public ResponseEntity<ParkingSlot> parkVehicle(@RequestParam String vehicleNumber) {
        return ResponseEntity.ok(service.assignSlot(vehicleNumber));
    }

    @PostMapping("/unpark/{vehicleNumber}")
    public ResponseEntity<ParkingSlot> unparkVehicle(@PathVariable String vehicleNumber) {
        return ResponseEntity.ok(service.releaseSlot(vehicleNumber));
    }
}