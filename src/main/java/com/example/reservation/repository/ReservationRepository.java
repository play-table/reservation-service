package com.example.reservation.repository;

import com.example.reservation.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository <Reservation, UUID> {
    Optional<Reservation> findByStoreId(UUID storeId);
    List<Reservation> findAllByCustomerId(UUID customerId);
}
