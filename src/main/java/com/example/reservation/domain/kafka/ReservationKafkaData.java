package com.example.reservation.domain.kafka;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Getter
public class ReservationKafkaData {
    private UUID storeId;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate reservationDay;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime reservationTime;
    private Integer totalPeople;
    private ReservationStatus status;
    private String customerId;
    private String customerName;

    public ReservationKafkaData(Reservation reservation) {
        this.storeId = reservation.getStoreId();
        this.reservationDay = reservation.getReservationDay();
        this.reservationTime = reservation.getReservationTime();
        this.totalPeople = reservation.getTotalPeople();
        this.status = reservation.getStatus();
        this.customerId = String.valueOf(reservation.getCustomerId());
        this.customerName = reservation.getCustomerName();;
    }
}
