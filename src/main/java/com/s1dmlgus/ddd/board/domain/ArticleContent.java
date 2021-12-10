package com.s1dmlgus.ddd.board.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;


@Embeddable
@AllArgsConstructor
@Getter
public class ArticleContent {

    private String content;
    private String contentType;

    protected ArticleContent() {
    }

}
