package com.s1dmlgus.ddd.order;

import java.util.List;

public class Order {

    private OrderState state;                               // 주문 상태
    private ShippingInfo shippingInfo;                      // 배송 정보
    private List<OrderLine> orderLines;                     // 주문 항목
    private int totalAmounts;                               // 주문 총 가격

    
    // 주문 생성자
    public Order(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    // 주문 항목 주입
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // 주문 항복 유효성 검사
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문 항목이 없습니다.");
        }
    }

    // 주문 총 가격
    private void calculateTotalAmounts(){
        this.totalAmounts = orderLines.stream().mapToInt(OrderLine::getAmounts).sum();

    }

    // 배송지 정보 변경
    public void changeShippingInfo(ShippingInfo newShippingInfo) {

        if (!isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in" + state);
        }

        this.shippingInfo = newShippingInfo;
    }

    // 배송지 정보 변경조건
    private boolean isShippingChangeable(){
        return state == OrderState.PAYMENT_WAITING ||
                state == OrderState.PREPARING;

    }

    // 출고 상태 변경
    public void changeShipped(){

        this.state = OrderState.SHIPPED;
    }

    // 주문 취소
    public void cancel(){

    }

    // 결제 완료
    public void completePayment(){

    }
}
