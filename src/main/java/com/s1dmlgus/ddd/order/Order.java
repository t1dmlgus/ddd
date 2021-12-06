package com.s1dmlgus.ddd.order;

public class Order {

    private OrderState state;
    private ShippingInfo shippingInfo;


    // 배송지 정보변경
    public void changeShippingInfo(ShippingInfo newShippingInfo) {

        if (!isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in" + state);
        }

        this.shippingInfo = newShippingInfo;
    }
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
