package com.example.flightstatus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightStatusApplication implements CommandLineRunner {

    @Autowired
    private FlightStatusRepository flightStatusRepository;
	public static void main(String[] args) {
		SpringApplication.run(FlightStatusApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        // Add initial flight statuses
        FlightStatus flight1 = new FlightStatus();
        flight1.setFlightNumber("AA123");
        flight1.setStatus("On Time");

        FlightStatus flight2 = new FlightStatus();
        flight2.setFlightNumber("BA456");
        flight2.setStatus("Delayed");

        FlightStatus flight3 = new FlightStatus();
        flight3.setFlightNumber("CA789");
        flight3.setStatus("Cancelled");

        flightStatusRepository.save(flight1);
        flightStatusRepository.save(flight2);
        flightStatusRepository.save(flight3);
    }
}

