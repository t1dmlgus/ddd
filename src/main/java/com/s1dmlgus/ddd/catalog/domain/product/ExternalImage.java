package com.s1dmlgus.ddd.catalog.domain.product;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
public class ExternalImage extends Image{

    protected ExternalImage(){}
    public ExternalImage(String path) {
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
