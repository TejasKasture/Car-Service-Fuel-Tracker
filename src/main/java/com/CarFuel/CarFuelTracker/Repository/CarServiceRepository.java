package com.CarFuel.CarFuelTracker.Repository;



import com.CarFuel.CarFuelTracker.model.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
    // Custom query methods can be added here if needed
}