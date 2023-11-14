package com.flavio.easystock.controllers;

import com.flavio.easystock.dtos.requests.ProductRequest;
import com.flavio.easystock.dtos.responses.ProductResponse;
import com.flavio.easystock.services.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper mapper;

    public ProductController(ProductService productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        var result = productService.create(request);
        var mappedDto = mapper.map(result, ProductResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(mappedDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        var result = productService.findAll();
        var mappedDto = result
                .stream()
                .map(x -> mapper.map(x, ProductResponse.class))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        var result = productService.findById(id);
        var mappedDto = mapper.map(result, ProductResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        var result = productService.update(id, request);
        var mappedDto = mapper.map(result, ProductResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
