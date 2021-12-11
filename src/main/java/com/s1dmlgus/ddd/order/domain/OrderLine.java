package com.s1dmlgus.ddd.order.domain;

import com.s1dmlgus.ddd.catalog.domain.product.Product;
import com.s1dmlgus.ddd.catalog.domain.product.ProductId;
import com.s1dmlgus.ddd.common.model.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable
public class OrderLine {

    @Embedded
    private ProductId productId;                  // 상품

    @Column(name = "price")
    private Money price;                      // 상품 가격

    @Column(name = "quantity")
    private int quantity;                     // 상품 개수

    @Column(name = "amounts")
    private Money amounts;                    // 구매 가격 합


    protected OrderLine(){}

    /*
        Money가 불변 객체가 아니라면,
        price 파라미터가 변경될 때 발생하는 문제를 방지하기 위해
        데이터를 복사한 새로운 객체를 생성해야 한다.
     */

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    // 구매 가격 합 생성
    private Money calculateAmounts(){
        return price.multiply(quantity);
    }

    // 구매 가격 합 반환
    public Money getAmounts(){
        return amounts;
    }

}
