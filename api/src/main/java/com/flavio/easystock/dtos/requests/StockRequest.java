package com.flavio.easystock.dtos.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class StockRequest {

    @Min(value = 1, message = "Quantity value must be at least 1.")
    private int quantity;

    @DecimalMin(value = "0.01", message = "Unit price value must be at least $ 0.01.")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "Unit price must have at most 2 decimal places.")
    private BigDecimal unitPrice;
}
