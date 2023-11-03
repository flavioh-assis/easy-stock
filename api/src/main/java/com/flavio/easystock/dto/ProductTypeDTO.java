package com.flavio.easystock.dto;

import com.flavio.easystock.entities.ProductType;
import org.springframework.beans.BeanUtils;

public class ProductTypeDTO {

    private Long id;
    private String name;

    public ProductTypeDTO() {
    }

    public ProductTypeDTO(ProductType entity) {
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
}
