package com.flavio.easystock.repositories;

import com.flavio.easystock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
