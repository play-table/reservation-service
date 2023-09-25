package com.example.reservation.controller;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.request.OpenRequest;
import com.example.reservation.domain.request.ReservationRequest;
import com.example.reservation.domain.response.ReservationResponse;
import com.example.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    @PostMapping("/{storeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable("storeId") String storeId, @RequestBody ReservationRequest request) {
        reservationService.save(request,storeId);
    }

    @PutMapping("/{storeId}/{status}")
    public void updateStatus(@PathVariable("storeId") String storeId, @PathVariable("status") String status) {
        reservationService.updateStatus(storeId, status);
    }

    @PostMapping("/{storeId}/open")
    public void reservationOpen(@PathVariable("storeId") String storeId, @RequestBody OpenRequest request) {
        reservationService.reservationOpen(storeId, request);
    }

    @GetMapping("/{customerId}")
    public List<ReservationResponse> reservationHistory(
            @PathVariable String customerId) {
            return reservationService.reservationHistory(customerId);
    }

}
