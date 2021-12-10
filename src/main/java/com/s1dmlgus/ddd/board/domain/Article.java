package com.s1dmlgus.ddd.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@SecondaryTable(name = "article_content", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@Table(name = "article")
@AllArgsConstructor
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @AttributeOverrides({
            @AttributeOverride(name = "content", column = @Column(table = "article_content")),
            @AttributeOverride(name = "contentType", column = @Column(table = "article_content"))
    })
    @Embedded
    private ArticleContent content;


    protected Article() { }


}
