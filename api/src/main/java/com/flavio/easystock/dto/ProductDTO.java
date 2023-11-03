package com.flavio.easystock.dto;

import com.flavio.easystock.entities.*;
import org.springframework.beans.BeanUtils;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private ProductType type;

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
