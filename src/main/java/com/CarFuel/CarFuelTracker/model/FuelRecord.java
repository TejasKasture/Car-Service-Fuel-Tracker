package com.CarFuel.CarFuelTracker.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuel_records")
public class FuelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fuel_date", nullable = false)
    private LocalDate fuelDate;

    @Column(nullable = false)
    private Double liters;

    @Column(name = "price_per_liter", nullable = false)
    private Double pricePerLiter;

    @Column(name = "total_cost", nullable = false)
    private Double totalCost;

    @Column(name = "odometer_reading", nullable = false)
    private Double odometerReading;

    // Constructors
    public FuelRecord() {}

    public FuelRecord(LocalDate fuelDate, Double liters, Double pricePerLiter, Double totalCost, Double odometerReading) {
        this.fuelDate = fuelDate;
        this.liters = liters;
        this.pricePerLiter = pricePerLiter;
        this.totalCost = totalCost;
        this.odometerReading = odometerReading;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFuelDate() {
        return fuelDate;
    }

    public void setFuelDate(LocalDate fuelDate) {
        this.fuelDate = fuelDate;
    }

    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double liters) {
        this.liters = liters;
    }

    public Double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(Double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Double odometerReading) {
        this.odometerReading = odometerReading;
    }
}
