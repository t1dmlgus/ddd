package com.s1dmlgus.ddd.order.domain;


import com.s1dmlgus.ddd.member.domain.MemberId;
import lombok.Getter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Orderer {


    @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    protected Orderer(){}
    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderer orderer = (Orderer) o;
        return Objects.equals(memberId, orderer.memberId) && Objects.equals(name, orderer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name);
    }
}
