package com.flavio.easystock.controllers;

import com.flavio.easystock.dtos.requests.StockRequest;
import com.flavio.easystock.dtos.responses.StockResponse;
import com.flavio.easystock.services.StockService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

    private final StockService stockService;
    private final ModelMapper mapper;

    public StockController(StockService stockService, ModelMapper mapper) {
        this.stockService = stockService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<StockResponse>> findAll() {
        var result = stockService.findAll();
        var mappedDto = result
                .stream()
                .map(x -> mapper.map(x, StockResponse.class))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponse> findById(@PathVariable Long id) {
        var result = stockService.findById(id);
        var mappedDto = mapper.map(result, StockResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @PutMapping("/{id}/add")
    public ResponseEntity<StockResponse> add(@PathVariable Long id, @Valid @RequestBody StockRequest request) {
        var result = stockService.add(id, request);
        var mappedDto = mapper.map(result, StockResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }

    @PutMapping("/{id}/remove")
    public ResponseEntity<StockResponse> remove(@PathVariable Long id, @Valid @RequestBody StockRequest request) throws Exception {
        var result = stockService.remove(id, request);
        var mappedDto = mapper.map(result, StockResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(mappedDto);
    }
}
