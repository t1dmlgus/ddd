package com.s1dmlgus.ddd.order;

public class OrderLine {

    private Product product;                // 상품
    private int price;                      // 상품 가격
    private int quantity;                   // 상품 개수
    private int amounts;                    // 구매 가격 합


    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    // 구매 가격 합 생성
    private int calculateAmounts(){
        return price * quantity;
    }

    // 구매 가격 합 반환
    public int getAmounts(){
        return amounts;
    }

}
