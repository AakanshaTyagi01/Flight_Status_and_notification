package com.example.flightstatus.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic flightStatusTopic() {
        return TopicBuilder.name("flight_status_updates")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
