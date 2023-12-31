package com.example.reservation.service;

import com.example.reservation.client.api.StoreClient;
import com.example.reservation.domain.entity.Reservation;
import com.example.reservation.domain.entity.ReservationStatus;
import com.example.reservation.domain.entity.StoreReservationInformation;
import com.example.reservation.domain.kafka.ReservationKafkaData;
import com.example.reservation.domain.kafka.StoreUpdateKafkaData;
import com.example.reservation.domain.request.OpenRequest;
import com.example.reservation.domain.request.ReservationRequest;
import com.example.reservation.domain.response.ReservationResponse;
import com.example.reservation.kafka.ReservationProducer;
import com.example.reservation.kafka.StoreConsumer;
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
    private final ReservationProducer reservationProducer;
//    private final StoreClient storeClient;

    public void save(ReservationRequest request, String storeId) {
//        Reservation save = reservationRepository.save(request.toEntity(storeId));
//        storeClient.increaseReservation(UUID.fromString(storeId));
        Reservation save = reservationRepository.save(request.toEntity(storeId));
        ReservationKafkaData reservationKafkaData = new ReservationKafkaData(save);
        send(reservationKafkaData);
    }

    public void send(ReservationKafkaData data) {
        reservationProducer.send(data);
    }

    public void update(StoreUpdateKafkaData data) {
        Optional<StoreReservationInformation> byId = storeReservationInformationRepository.findById(data.storeId());
        if (byId.isEmpty()) {
            return;
        }
        StoreReservationInformation information = byId.get();
        information.setName(data.name());
        information.setAddress(data.address());
   }

    public void updateStatus(String storeId, String status) {
        Reservation byStoreId = findById(storeId); // 아래에 findById에서 storeId없으면 오류 띄우는거 있음..
        byStoreId.setStatus(ReservationStatus.valueOf(status.toUpperCase()));

//      ## 빌더는 새로 만드는거라 업데이트를 하는 건 위에처럼 set으로 해당 status만 바꿔주자!
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

        List<Reservation> allByCustomerId = reservationRepository.findAllByCustomerId(UUID.fromString(customerId));


        return allByCustomerId.stream().map(ReservationResponse::new).toList();
    }

}
