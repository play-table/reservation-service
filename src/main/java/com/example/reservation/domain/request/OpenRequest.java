package com.example.reservation.domain.request;

import com.example.reservation.domain.entity.StoreReservationInformation;

import java.util.UUID;

public class OpenRequest {
    private String storeId;
    private Integer seats;

    public StoreReservationInformation toEntity(String storeId) {
        return StoreReservationInformation.builder()
                .storeId(UUID.fromString(storeId))
                .seats(seats)
                .build();
    }

}
