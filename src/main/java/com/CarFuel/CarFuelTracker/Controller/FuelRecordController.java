package com.CarFuel.CarFuelTracker.Controller;


import com.CarFuel.CarFuelTracker.model.FuelRecord;
import com.CarFuel.CarFuelTracker.Service.FuelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-records")
public class FuelRecordController {

    @Autowired
    private FuelRecordService fuelRecordService;

    // Add a new fuel record
    @PostMapping
    public ResponseEntity<FuelRecord> addFuelRecord(@RequestBody FuelRecord fuelRecord) {
        FuelRecord newRecord = fuelRecordService.addFuelRecord(fuelRecord);
        return ResponseEntity.ok(newRecord);
    }

    // Get all fuel records
    @GetMapping
    public ResponseEntity<List<FuelRecord>> getAllFuelRecords() {
        List<FuelRecord> records = fuelRecordService.getAllFuelRecords();
        return ResponseEntity.ok(records);
    }

    // Get a fuel record by ID
    @GetMapping("/{id}")
    public ResponseEntity<FuelRecord> getFuelRecordById(@PathVariable Long id) {
        return fuelRecordService.getFuelRecordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a fuel record by ID
    @PutMapping("/{id}")
    public ResponseEntity<FuelRecord> updateFuelRecord(
            @PathVariable Long id, @RequestBody FuelRecord updatedRecord) {
        try {
            FuelRecord record = fuelRecordService.updateFuelRecord(id, updatedRecord);
            return ResponseEntity.ok(record);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a fuel record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelRecord(@PathVariable Long id) {
        fuelRecordService.deleteFuelRecord(id);
        return ResponseEntity.noContent().build();
    }

    // Calculate average mileage
    @GetMapping("/mileage")
    public ResponseEntity<Double> calculateMileage() {
        double mileage = fuelRecordService.calculateMileage();
        return ResponseEntity.ok(mileage);
    }
}
