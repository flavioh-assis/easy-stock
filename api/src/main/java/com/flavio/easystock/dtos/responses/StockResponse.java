package com.flavio.easystock.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockResponse {

    private ProductResponse product;
    private int quantity;
    private BigDecimal unitPrice;
}
