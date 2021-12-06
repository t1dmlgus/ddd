package com.s1dmlgus.ddd.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ShippingInfo {

    private String receiverName;
    private String receiverPhoneNumber;
    private String shippingAddr01;
    private String shippingAddr02;
    private String shippingAddr03;

}
