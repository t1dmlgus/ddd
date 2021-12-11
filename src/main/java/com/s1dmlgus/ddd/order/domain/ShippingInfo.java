package com.s1dmlgus.ddd.order.domain;
import lombok.Getter;

import javax.persistence.*;


@Embeddable
public class ShippingInfo {


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipcode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_address1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_address2")),
    })
    private Address address;

    @Embedded
    private Receiver receiver;

    @Column(name = "shipping_message")
    private String message;

}
