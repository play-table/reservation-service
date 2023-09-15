package com.example.reservation.domain.response;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationResponse {
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate reservationDay;
    @DateTimeFormat(pattern = "HH:mm")
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
        this.customerId = String.valueOf(reservation.getCustomerId());
        this.customerName = reservation.getCustomerName();

        System.out.println(this.reservationDay);
        System.out.println(this.reservationTime);
        System.out.println(this.totalPeople);
        System.out.println(this.status);
        System.out.println(this.customerId);
        System.out.println(this.customerName);
    }
}
