package com.example.reservation.domain.kafka;

import com.example.reservation.domain.entity.StoreReservationInformation;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record StoreUpdateKafkaData(UUID storeId,
String name,
String contact,
String address,
String category,
String imageUrl,
@DateTimeFormat(pattern = "HH:mm") LocalTime openTime,
@DateTimeFormat(pattern = "HH:mm") LocalTime closeTime,
@DateTimeFormat(pattern = "HH:mm") LocalTime breakStartTime,
@DateTimeFormat(pattern = "HH:mm") LocalTime breakEndTime,
List<String> days) {

    public StoreReservationInformation toEntity() {
        return new StoreReservationInformation(storeId, name, address);
    }
}
