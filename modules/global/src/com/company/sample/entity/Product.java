package com.company.sample.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "SAMPLE_PRODUCT")
@Entity(name = "sample_Product")
@NamePattern("%s|name")
public class Product extends BaseStringIdEntity {
    private static final long serialVersionUID = 2563077182498580431L;

    @Id
    @Column(name = "PROD_CODE", nullable = false, length = 10)
    private String prodCode;

    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(String id) {
        this.prodCode = id;
    }

    @Override
    public String getId() {
        return prodCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }
}