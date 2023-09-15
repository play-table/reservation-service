package com.example.reservation.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient("STORE-SERVICE")
public interface StoreClient {
    @PutMapping("/api/v1/store/{storeId}/reservation")
    void increaseReservation(@PathVariable("storeId") UUID storeId);
}
