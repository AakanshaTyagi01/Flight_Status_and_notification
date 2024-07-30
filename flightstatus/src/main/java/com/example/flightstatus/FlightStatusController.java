package com.example.flightstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/flightstatus")
public class FlightStatusController {

    @Autowired
    private FlightStatusService service;

    @GetMapping
    public List<FlightStatus> getAllFlightStatuses() {
        return service.getAllFlightStatuses();
    }

    @GetMapping("/{id}")
    public FlightStatus getFlightStatusById(@PathVariable Long id) {
        return service.getFlightStatusById(id);
    }

    @PostMapping
    public FlightStatus createFlightStatus(@RequestBody FlightStatus flightStatus) {
        return service.saveFlightStatus(flightStatus);
    }

    @PutMapping("/{id}")
    public FlightStatus updateFlightStatus(@PathVariable Long id, @RequestBody FlightStatus flightStatus) {
        FlightStatus existingFlightStatus = service.getFlightStatusById(id);
        if (existingFlightStatus != null) {
            existingFlightStatus.setFlightNumber(flightStatus.getFlightNumber());
            existingFlightStatus.setStatus(flightStatus.getStatus());
            return service.saveFlightStatus(existingFlightStatus);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlightStatus(@PathVariable Long id) {
        service.deleteFlightStatus(id);
    }
    
    @PostMapping("/check")
    public FlightStatusResponse checkFlightStatus(@RequestBody FlightStatusRequest request) {
    System.out.println("Received request with data: " + request);
    Optional<FlightStatus> flightStatus = service.getFlightStatus(request.getDeparture(), request.getArrival(), request.getDate(), request.getFlightNumber(), request.getBookingId());

    if (flightStatus.isPresent()) {
        FlightStatus status = flightStatus.get();
        return new FlightStatusResponse(
            status.getFlightNumber(), 
            status.getStatus(), 
            status.getDepartureTime(), 
            "From Database"
        );
    } else {
        FlightStatusResponse apiResponse = service.getFlightStatusFromApi(
            request.getDeparture(), 
            request.getArrival(), 
            request.getDate(), 
            request.getFlightNumber(), 
            request.getBookingId()
        );
        System.out.println("API Response: " + apiResponse);
        return apiResponse; // Directly return the response from the service if it's already a FlightStatusResponse
    }
}

}