package com.CarFuel.CarFuelTracker.Repository;



import com.CarFuel.CarFuelTracker.model.FuelRecord ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRecordRepository extends JpaRepository<FuelRecord, Long> {
    // Custom query methods can be added here if needed
}

