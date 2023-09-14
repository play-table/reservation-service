package com.example.reservation.domain.entity;

public enum ReservationStatus {
    WAITING, // 대기중
    APPROVED, // 예약승인
    CUSTOMER_CANCELED, // 고객취소
    RESTAURANT_CANCELED, // 매장취소
    FINISHED // 식사끝
}
