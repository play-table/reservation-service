package com.example.reservation.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder
@Entity
public class StoreReservationInformation {
    @Id
    private UUID storeId;
    private Integer seats;
}
