package com.example.flightstatus.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FlightStatusConsumer {

    @KafkaListener(topics = "flight_status_updates", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        // Add logic to handle the consumed message, such as sending notifications
    }
}
