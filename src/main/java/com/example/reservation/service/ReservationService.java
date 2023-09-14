package com.example.reservation.service;

import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import com.example.reservation.domain.request.OpenRequest;
import com.example.reservation.domain.request.ReservationRequest;
import com.example.reservation.domain.response.ReservationResponse;
import com.example.reservation.repository.ReservationRepository;
import com.example.reservation.repository.StoreReservationInformationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final StoreReservationInformationRepository storeReservationInformationRepository;

    public void save(ReservationRequest request, String storeId) {
        Reservation save = reservationRepository.save(request.toEntity(storeId));
    }

    public void updateStatus(String storeId, String status) {
        Reservation byStoreId = findById(storeId); // 아래에 findById에서 storeId없으면 오류 띄우는거 있음..
        byStoreId.setStatus(ReservationStatus.valueOf(status.toUpperCase()));


//        Reservation reservation = Reservation.builder()
//                .storeId(UUID.fromString(storeId))
//                .status("예약취소")
//                .build();
//        reservationRepository.save(reservation);

    }

    private Reservation findById(String storeId) {
        Reservation byStoreId = reservationRepository
                .findByStoreId(UUID.fromString(storeId))
                .orElseThrow(()->new
                NoSuchElementException("storeId 없음"));
        return byStoreId;
    }

//    TODO 매장 좌석 추가 -> store table이 필요하지 않나?
    public void reservationOpen(String storeId, OpenRequest request) {
//        storeReservationInformationRepository.save(request.toEntity());
    }

    public List<ReservationResponse> reservationHistory(String customerId) {
        Reservation allByCustomerId = reservationRepository.getAllByCustomerId(UUID.fromString(customerId));
//        allByCustomerId.stream().w
        return null;
    }


}
