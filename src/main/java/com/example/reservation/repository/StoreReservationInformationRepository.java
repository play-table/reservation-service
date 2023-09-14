package com.example.reservation.repository;

import com.example.reservation.domain.entity.StoreReservationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreReservationInformationRepository extends JpaRepository <StoreReservationInformation, UUID> {
}
