package com.s1dmlgus.ddd.order;

public class OrderLine {

    private Product product;                  // 상품
    private Money price;                      // 상품 가격
    private int quantity;                     // 상품 개수
    private Money amounts;                    // 구매 가격 합


    /*
        Money가 불변 객체가 아니라면,
        price 파라미터가 변경될 때 발생하는 문제를 방지하기 위해
        데이터를 복사한 새로운 객체를 생성해야 한다.
     */

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
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
