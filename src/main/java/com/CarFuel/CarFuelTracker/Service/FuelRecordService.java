package com.CarFuel.CarFuelTracker.Service;

import com.CarFuel.CarFuelTracker.Repository.FuelRecordRepository;
import com.CarFuel.CarFuelTracker.model.FuelRecord ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelRecordService {

    @Autowired
    private FuelRecordRepository fuelRecordRepository;

    // Add a new fuel record
    public FuelRecord addFuelRecord(FuelRecord fuelRecord) {
        return fuelRecordRepository.save(fuelRecord);
    }

    // Get all fuel records
    public List<FuelRecord> getAllFuelRecords() {
        return fuelRecordRepository.findAll();
    }

    // Get a fuel record by ID
    public Optional<FuelRecord> getFuelRecordById(Long id) {
        return fuelRecordRepository.findById(id);
    }

    // Update a fuel record
    public FuelRecord updateFuelRecord(Long id, FuelRecord updatedFuelRecord) {
        return fuelRecordRepository.findById(id)
                .map(record -> {
                    record.setFuelDate(updatedFuelRecord.getFuelDate());
                    record.setLiters(updatedFuelRecord.getLiters());
                    record.setPricePerLiter(updatedFuelRecord.getPricePerLiter());
                    record.setTotalCost(updatedFuelRecord.getTotalCost());
                    record.setOdometerReading(updatedFuelRecord.getOdometerReading());
                    return fuelRecordRepository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("Fuel record not found with ID: " + id));
    }

    // Delete a fuel record
    public void deleteFuelRecord(Long id) {
        fuelRecordRepository.deleteById(id);
    }

    // Calculate average mileage
    public double calculateMileage() {
        List<FuelRecord> records = fuelRecordRepository.findAll();
        if (records.isEmpty()) return 0;

        double totalDistance = 0;
        double totalFuel = 0;

        for (int i = 1; i < records.size(); i++) {
            double distance = records.get(i).getOdometerReading() - records.get(i - 1).getOdometerReading();
            double fuelUsed = records.get(i).getLiters();
            totalDistance += distance;
            totalFuel += fuelUsed;
        }

        return totalFuel == 0 ? 0 : totalDistance / totalFuel;
    }
}
