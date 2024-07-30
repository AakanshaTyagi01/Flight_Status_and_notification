package com.example.flightstatus;

import com.example.flightstatus.kafka.FlightStatusProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FlightStatusService {

    @Autowired
    private FlightStatusRepository repository;

    @Autowired
    private FlightStatusProducer producer;

    private final String API_KEY = "e2687bc909d8fa40e02eed9029d7466f"; // AviationStack API key
    private final String API_URL = "http://api.aviationstack.com/v1/flights?access_key=" + API_KEY;

    public List<FlightStatus> getAllFlightStatuses() {
        return repository.findAll();
    }

    public FlightStatus getFlightStatusById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FlightStatus saveFlightStatus(FlightStatus flightStatus) {
        FlightStatus savedStatus = repository.save(flightStatus);
        producer.sendMessage("Flight status updated: " + savedStatus.getFlightNumber() + " - " + savedStatus.getStatus());
        return savedStatus;
    }

    public void deleteFlightStatus(Long id) {
        repository.deleteById(id);
    }

    public Optional<FlightStatus> getFlightStatus(String departure, String arrival, String date, String flightNumber, String bookingId) {
        return repository.findByDepartureAndArrivalAndDateAndFlightNumberAndBookingId(departure, arrival, date, flightNumber, bookingId);
    }

    public FlightStatusResponse getFlightStatusFromApi(
            String departureLocation, String arrivalLocation, String dateOfBooking,
            String flightNumber, String bookingId) {

        RestTemplate restTemplate = new RestTemplate();
        StringBuilder url = new StringBuilder(API_URL);
        url.append("&dep_iata=").append(departureLocation);
        url.append("&arr_iata=").append(arrivalLocation);
        url.append("&flight_date=").append(dateOfBooking);

        if (flightNumber != null && !flightNumber.isEmpty()) {
            url.append("&flight_iata=").append(flightNumber);
        }
        if (bookingId != null && !bookingId.isEmpty()) {
            url.append("&flight_number=").append(bookingId);
        }

        AviationApiResponse apiResponse = restTemplate.getForObject(url.toString(), AviationApiResponse.class);

        System.out.println("API Response: " + apiResponse); // Debugging line

        if (apiResponse != null && apiResponse.getData() != null && !apiResponse.getData().isEmpty()) {
            AviationApiResponse.Data data = apiResponse.getData().get(0);
            FlightStatusResponse response = new FlightStatusResponse(data.getFlight_iata(), data.getFlight_status(), data.getDeparture().getTimezone(), "From API");
            producer.sendMessage("Flight status fetched from API: " + response.getFlightNumber() + " - " + response.getStatus());
            return response;
        } else {
            return new FlightStatusResponse(flightNumber, "Unknown", "Unknown", "From API");
        }
    }
}
