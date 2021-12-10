package com.s1dmlgus.ddd.catalog.domain.product;

import com.s1dmlgus.ddd.common.jpa.MoneyConverter;
import com.s1dmlgus.ddd.common.model.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;
    private String detail;


    @OneToMany(cascade = {CascadeType.PERSIST ,CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    protected Product(){}

    public Product(ProductId id, String name, Money price, String detail, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.images = images;
    }

    public List<Image> getImages(){
        return Collections.unmodifiableList(images);
    }

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }


}
