package com.s1dmlgus.ddd.order;

import java.util.stream.IntStream;

public class Money {

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }



    public Money add(Money money) {
        return new Money(this.value + money.getValue());
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}
