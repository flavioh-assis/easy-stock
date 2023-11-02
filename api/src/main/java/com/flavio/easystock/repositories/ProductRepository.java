package com.flavio.easystock.repositories;

import com.flavio.easystock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
