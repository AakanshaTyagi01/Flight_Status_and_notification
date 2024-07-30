package com.example.flightstatus;


public class FlightStatusResponse {
    private String flightNumber;
    private String status;
    private String departureTime; 
    private String source;

    // Constructor
    public FlightStatusResponse(String flightNumber, String status, String departureTime, String source) {
        this.flightNumber = flightNumber;
        this.status = status;
        this.departureTime = departureTime;
        this.source = source;
    }

    private String validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("String value cannot be null or empty.");
        }
        return input;
    }   


    // Getters and setters

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getSource() {
        return source;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = validateString(flightNumber); // Assuming validation is needed
    }

    public void setStatus(String status) {
        this.status = validateString(status); // Assuming validation is needed
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime; // Assuming no validation required
    }

    public void setSource(String source) {
        this.source = validateString(source); // Assuming validation is needed
    }
}
