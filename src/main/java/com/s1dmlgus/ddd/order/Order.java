package com.s1dmlgus.ddd.order;

public class Order {

    private OrderState state;
    private ShippingInfo shippingInfo;

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

    public void changeShipped(){
        // 로직 검사
        this.state = OrderState.SHIPPED;
    }
}
