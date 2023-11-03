package com.flavio.easystock.dto;

import com.flavio.easystock.entities.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class StockDTO {

    private Long id;
    private Product product;
    private int quantity;
    private BigDecimal unitPrice;

    public StockDTO() {
    }

    public StockDTO(Stock entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
