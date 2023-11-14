package com.flavio.easystock.services;

import com.flavio.easystock.dtos.requests.ProductTypeRequest;
import com.flavio.easystock.entities.ProductType;
import com.flavio.easystock.exceptions.EntityNotFoundException;
import com.flavio.easystock.repositories.ProductTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;
    private final ModelMapper mapper;

    public ProductTypeService(ProductTypeRepository productTypeRepository, ModelMapper mapper) {
        this.productTypeRepository = productTypeRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ProductType create(ProductTypeRequest request) {
        var entity = mapper.map(request, ProductType.class);

        return productTypeRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ProductType findById(Long id) {
        return productTypeRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("product type", id)
                );
    }

    @Transactional
    public ProductType update(Long id, ProductTypeRequest request) {
        var entity = this.findById(id);
        mapper.map(request, entity);

        return productTypeRepository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        var entity = this.findById(id);

        productTypeRepository.delete(entity);
    }
}
