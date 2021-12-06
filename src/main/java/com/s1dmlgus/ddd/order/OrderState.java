package com.s1dmlgus.ddd.order;

public enum OrderState {

    PAYMENT_WAITING,                // 결제 대기 중
    PREPARING,                      // 상품 준비 중
    SHIPPED,                        // 출고 완료
    DELIVERING,                     // 배송 중
    DELIVERY_COMPLETED,             // 배송 완료
    CANCELED;                       // 주문 취소

}
