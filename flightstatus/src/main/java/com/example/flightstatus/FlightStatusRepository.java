package com.example.flightstatus;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {
    Optional<FlightStatus> findByDepartureAndArrivalAndDateAndFlightNumberAndBookingId(
        String departure, String arrival, String date, String flightNumber, String bookingId);
}
