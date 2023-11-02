package com.flavio.easystock.controllers;

import com.flavio.easystock.entities.ProductType;
import com.flavio.easystock.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-types")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> findAll() {
        return productTypeService.findAll();
    }
}
