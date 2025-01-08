package com.CarFuel.CarFuelTracker.Service;

import com.CarFuel.CarFuelTracker.Repository.CarServiceRepository;
import com.CarFuel.CarFuelTracker.model.CarService ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceService {

    @Autowired
    private CarServiceRepository carServiceRepository;

    // Add a new service record
    public CarService addService(CarService carService) {
        return carServiceRepository.save(carService);
    }



    // Get all service records
    public List<CarService> getAllServices() {
        return carServiceRepository.findAll();
    }

    // Get a service record by ID
    public Optional<CarService> getServiceById(Long id) {
        return carServiceRepository.findById(id);
    }

    // Update a service record
    public CarService updateService(Long id, CarService updatedService) {
        return carServiceRepository.findById(id)
                .map(service -> {
                    service.setServiceDate(updatedService.getServiceDate());
                    service.setServiceType(updatedService.getServiceType());
                    service.setCost(updatedService.getCost());
                    service.setServiceCenter(updatedService.getServiceCenter());
                    return carServiceRepository.save(service);
                })
                .orElseThrow(() -> new RuntimeException("Service not found with ID: " + id));
    }

    // Delete a service record
    public void deleteService(Long id) {
        carServiceRepository.deleteById(id);
    }
}
