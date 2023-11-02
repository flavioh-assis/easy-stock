package com.flavio.easystock.controllers;

import com.flavio.easystock.entities.Stock;
import com.flavio.easystock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> findAll() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Stock> findById(@PathVariable Long id) {
        return stockService.findById(id);
    }
}
