package com.CarFuel.CarFuelTracker.Controller;



import com.CarFuel.CarFuelTracker.model.CarService ;
import com.CarFuel.CarFuelTracker.Service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-services")
public class CarServiceController {

    @Autowired
    private CarServiceService carServiceService;

    // Add a new car service
    @PostMapping
    public ResponseEntity<CarService> addService(@RequestBody CarService carService) {
        CarService newService = carServiceService.addService(carService);
        return ResponseEntity.ok(newService);
    }

    // Get all car services
    @GetMapping
    public ResponseEntity<List<CarService>> getAllServices() {
        List<CarService> services = carServiceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    // Get a car service by ID
    @GetMapping("/{id}")
    public ResponseEntity<CarService> getServiceById(@PathVariable Long id) {
        return carServiceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a car service by ID
    @PutMapping("/{id}")
    public ResponseEntity<CarService> updateService(
            @PathVariable Long id, @RequestBody CarService updatedService) {
        try {
            CarService service = carServiceService.updateService(id, updatedService);
            return ResponseEntity.ok(service);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a car service by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        carServiceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/test")
    public ResponseEntity<String> testEndpoint(@RequestBody String data) {
        return ResponseEntity.ok("Received data: " + data);
    }

}
