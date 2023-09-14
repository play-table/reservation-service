package com.example.reservation.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate reservationDay;
    private LocalTime reservationTime;
    private Integer totalPeople;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    private UUID storeId;
    private UUID customerId;
    private String customerName;
}
