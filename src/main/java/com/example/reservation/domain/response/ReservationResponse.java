package com.example.reservation.domain.response;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationResponse {
    private LocalDate reservationDay;
    private LocalTime reservationTime;
    private Integer totalPeople;
    private ReservationStatus status;

    private String customerId;
    private String customerName;

    public ReservationResponse(Reservation reservation) {
        this.reservationDay = reservation.getReservationDay();
        this.reservationTime = reservation.getReservationTime();
        this.totalPeople = reservation.getTotalPeople();
        this.status = reservation.getStatus();
        this.customerId = reservation.getCustomerName();
        this.customerName = reservation.getCustomerName();
    }
}
