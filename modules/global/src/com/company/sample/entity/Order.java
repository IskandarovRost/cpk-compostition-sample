package com.company.sample.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "SAMPLE_ORDER")
@Entity(name = "sample_Order")
@NamePattern("%s |amount")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -8651639140562527033L;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Composition
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_LINK", referencedColumnName = "ID")
    private List<OrderLine> lines;

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}