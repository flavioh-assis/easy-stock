package com.flavio.easystock.repositories;

import com.flavio.easystock.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
