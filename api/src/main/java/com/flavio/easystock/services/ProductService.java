package com.flavio.easystock.services;

import com.flavio.easystock.dtos.requests.ProductRequest;
import com.flavio.easystock.entities.Product;
import com.flavio.easystock.exceptions.EntityNotFoundException;
import com.flavio.easystock.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeService productTypeService;
    private final ModelMapper mapper;

    public ProductService(ProductRepository productRepository, ProductTypeService productTypeService, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.productTypeService = productTypeService;
        this.mapper = mapper;
    }

    @Transactional
    public Product create(ProductRequest request) {
        var type = productTypeService.findById(
                request.getType().getId()
        );
        var entity = new Product(request, type);

        return productRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("product", id)
                );
    }

    @Transactional
    public Product update(Long id, ProductRequest request) {
        var entity = this.findById(id);
        var type = productTypeService.findById(
                request.getType().getId()
        );

        mapper.map(request, entity);
        entity.setType(type);

        return productRepository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        var entity = this.findById(id);

        productRepository.delete(entity);
    }
}
