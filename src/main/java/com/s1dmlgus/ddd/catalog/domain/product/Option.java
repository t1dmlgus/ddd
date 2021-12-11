package com.s1dmlgus.ddd.catalog.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@AllArgsConstructor
@Getter
public class Option {

    @Column(name = "option_value")
    private String value;

    @Column(name = "option_title")
    private String title;

    protected Option(){}

}
