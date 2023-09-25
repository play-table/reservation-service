package com.example.reservation.kafka;

import com.example.reservation.domain.kafka.ReservationKafkaData;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationProducer {
    private final KafkaTemplate<String, ReservationKafkaData> kafkaTemplate;

    public void send(ReservationKafkaData data) {
        kafkaTemplate.send(TopicConfig.RESERVATION, data);
    }

}
