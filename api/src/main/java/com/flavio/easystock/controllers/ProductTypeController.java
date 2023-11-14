package com.flavio.easystock.controllers;

import com.flavio.easystock.dtos.requests.ProductTypeRequest;
import com.flavio.easystock.dtos.responses.ProductTypeResponse;
import com.flavio.easystock.services.ProductTypeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    private final ModelMapper mapper;

    public ProductTypeController(ProductTypeService productTypeService, ModelMapper mapper) {
        this.productTypeService = productTypeService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductTypeResponse> create(@Valid @RequestBody ProductTypeRequest request) {
        var result = productTypeService.create(request);
        var mappedDto = mapper.map(result, ProductTypeResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(mappedDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductTypeResponse>> findAll() {
        var result = productTypeService.findAll();
        var mappedDto = result
                .stream()
                .map(x -> mapper.map(x, ProductTypeResponse.class))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeResponse> findById(@PathVariable Long id) {
        var result = productTypeService.findById(id);
        var mappedDto = mapper.map(result, ProductTypeResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeResponse> update(@PathVariable Long id, @Valid @RequestBody ProductTypeRequest request) {
        var result = productTypeService.update(id, request);
        var mappedDto = mapper.map(result, ProductTypeResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productTypeService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
