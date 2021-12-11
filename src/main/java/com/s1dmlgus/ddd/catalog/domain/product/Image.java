package com.s1dmlgus.ddd.catalog.domain.product;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "image")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Getter
public abstract class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;


    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;


    protected Image(){ }
    public Image(String path) {
        this.path = path;
        this.uploadTime = new Date();
    }

    public abstract String getURL();
    public abstract boolean hasThumbnail();
    public abstract String getThumbnail();


}
