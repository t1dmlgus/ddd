package com.s1dmlgus.ddd.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Embeddable
public class Receiver {

    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phoneNumber")
    private String phoneNumber;

    protected Receiver() { }

}
