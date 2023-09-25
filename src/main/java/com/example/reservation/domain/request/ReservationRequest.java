package com.example.reservation.domain.request;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import com.example.reservation.domain.entity.StoreReservationInformation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ReservationRequest {
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate reservationDay;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime reservationTime;
    private Integer totalPeople;
    private ReservationStatus status;

    private String customerId;
    private String customerName;
    private UUID storeId;


    public Reservation toEntity(String storeId) {
        return Reservation.builder()
                .storeId(UUID.fromString(storeId))
                .reservationDay(reservationDay)
                .reservationTime(reservationTime)
                .totalPeople(totalPeople)
                .status(ReservationStatus.WAITING)
                .customerId(UUID.fromString(customerId))
                .customerName(customerName)
                .build();
    }


}
