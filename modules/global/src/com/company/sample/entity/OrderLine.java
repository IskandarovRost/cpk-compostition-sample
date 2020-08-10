package com.company.sample.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseGenericIdEntity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;

import javax.persistence.*;

@Table(name = "SAMPLE_ORDER_LINE")
@Entity(name = "sample_OrderLine")
@NamePattern("%s %s|order,product")
public class OrderLine extends BaseGenericIdEntity<KeyEntity> {
    private static final long serialVersionUID = -3872032066065715379L;

    @EmbeddedId
    private KeyEntity id;

    private @MetaProperty
    @Transient
    Order order;

    @Transient
    @MetaProperty
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        if (this.product == null && id.getProductCode() != null) {
            DataManager dm = AppBeans.get(DataManager.class);
            product = dm.load(LoadContext.create(Product.class).setId(id.getProductCode()));
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {id.setProductCode(product.getId());}
    }

    public Order getOrder() {
        if (this.order == null && id.getOrderLink() != null) {
            DataManager dm = AppBeans.get(DataManager.class);
            order = dm.load(LoadContext.create(Order.class).setId(id.getOrderLink()));
        }
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        if (order != null) {id.setOrderLink(order.getId());}
    }

    @Override
    public void setId(KeyEntity id) {
        this.id = id;
    }

    @Override
    public KeyEntity getId() {
        return id;
    }
}