package com.flavio.easystock.services;

import com.flavio.easystock.dtos.requests.StockRequest;
import com.flavio.easystock.entities.Stock;
import com.flavio.easystock.exceptions.EntityNotFoundException;
import com.flavio.easystock.repositories.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Stock findById(Long id) {
        return stockRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("stock", id)
                );
    }

    @Transactional
    public Stock add(Long id, StockRequest request) {
        var entity = this.findById(id);

        var currentTotal = calculateTotal(entity.getUnitPrice(), entity.getQuantity());
        var requestTotal = calculateTotal(request.getUnitPrice(), request.getQuantity());

        var newTotal = sum(currentTotal, requestTotal);
        var newQuantity = sum(entity.getQuantity(), request.getQuantity());
        var newUnitPrice = divide(newTotal, newQuantity);

        entity.setQuantity(newQuantity);
        entity.setUnitPrice(newUnitPrice);

        return stockRepository.save(entity);
    }

    @Transactional
    public Stock remove(Long id, StockRequest request) throws Exception {
        var entity = this.findById(id);
        var currentQuantity = entity.getQuantity();
        var requestQuantity = request.getQuantity();

        if (requestQuantity > currentQuantity)
            throw new Exception("The quantity to be removed cannot be bigger than the current quantity.");

        var currentTotal = calculateTotal(entity.getUnitPrice(), currentQuantity);
        var requestTotal = calculateTotal(request.getUnitPrice(), requestQuantity);

        var newTotal = subtract(currentTotal, requestTotal);
        var newQuantity = subtract(currentQuantity, requestQuantity);
        var newUnitPrice = divide(newTotal, newQuantity);

        entity.setQuantity(newQuantity);
        entity.setUnitPrice(newUnitPrice);

        return stockRepository.save(entity);
    }

    private BigDecimal calculateTotal(BigDecimal decimal, int quantity) {
        return decimal.multiply(new BigDecimal(quantity));
    }

    private BigDecimal divide(BigDecimal decimal, int quantity) {
        var decimalPlaces = 2;

        return decimal.divide(new BigDecimal(quantity), decimalPlaces, RoundingMode.CEILING);
    }

    private BigDecimal sum(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }

    private int sum(int value1, int value2) {
        return value1 + value2;
    }

    private BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2);
    }

    private int subtract(int value1, int value2) {
        return value1 - value2;
    }
}
