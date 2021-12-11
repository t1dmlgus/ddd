package com.s1dmlgus.ddd.member.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Member {

    @EmbeddedId
    private MemberId memberId;

    private String name;



}
