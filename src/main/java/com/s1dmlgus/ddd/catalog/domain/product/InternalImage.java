package com.s1dmlgus.ddd.catalog.domain.product;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image{

    protected InternalImage(){}
    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getURL() {
        return getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnail() {
        return null;
    }
}
