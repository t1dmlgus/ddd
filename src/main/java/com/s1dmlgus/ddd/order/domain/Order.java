package com.s1dmlgus.ddd.order.domain;

import com.s1dmlgus.ddd.common.model.Money;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="purchase_order")
@Access(AccessType.FIELD)
@Getter
public class Order {

    @EmbeddedId
    private OrderNo number;

    @Embedded
    private Orderer orderer;                        // 주문자

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;                       // 주문 상태

    @Embedded
    private ShippingInfo shippingInfo;              // 배송 정보

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;             // 주문 항목

    @Column(name = "total_amounts")
    private Money totalAmounts;                     // 주문 총 가격

    
    // 주문 생성자
    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderer(Orderer orderer) {

        if(orderer == null)
            throw new IllegalArgumentException(" 주문자가 없습니다.");
        this.orderer = orderer;
    }

    // 주문 항목 주입
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // 배송지 정보 주입
    private void setShippingInfo(ShippingInfo shippingInfo) {

        if (shippingInfo == null) {
            throw new IllegalArgumentException("배송정보가 없습니다.");
        }
        this.shippingInfo = shippingInfo;
    }



    // 주문 항복 유효성 검사
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("주문 항목이 없습니다.");
        }
    }

    // 주문 총 가격
    private void calculateTotalAmounts(){
        totalAmounts = new Money(orderLines.stream().mapToInt(x->x.getAmounts().getValue()).sum());

    }

    // 배송지 정보 변경
    public void changeShippingInfo(ShippingInfo newShippingInfo) {

        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    // 배송지 변경 유효성 검사
    private void verifyNotYetShipped() {
        if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalStateException("이미 출고 됬습니다.");
    }



    // 주문 취소
    public void cancel(){
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;

    }


    // 출고 상태 변경
    public void changeShipped(){
        this.state = OrderState.SHIPPED;
    }


    // 결제 완료
    public void completePayment(){

    }
}
