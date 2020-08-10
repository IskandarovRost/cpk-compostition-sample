package com.company.sample.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.UUID;

@MetaClass(name = "sample_KeyEntity")
@Embeddable
public class KeyEntity extends EmbeddableEntity {
    private static final long serialVersionUID = -3160428472596560086L;

    @Column(name = "ORDER_LINK")
    private UUID orderLink;

    @Column(name = "PRODUCT_CODE", length = 10)
    private String productCode;

    public void setOrderLink(UUID orderLink) {
        this.orderLink = orderLink;
    }

    public UUID getOrderLink() {
        return orderLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, orderLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyEntity entity = (KeyEntity) o;
        return Objects.equals(this.productCode, entity.productCode) &&
                Objects.equals(this.orderLink, entity.orderLink);
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}