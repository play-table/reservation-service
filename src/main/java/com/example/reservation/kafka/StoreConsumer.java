package com.example.reservation.kafka;

import com.example.reservation.domain.kafka.StoreUpdateKafkaData;
import com.example.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreConsumer {
    private final ReservationService reservationService;

    @KafkaListener(topics = TopicConfig.STORE)
    public void listen(StoreUpdateKafkaData data) {
        reservationService.update(data);
    }


}
