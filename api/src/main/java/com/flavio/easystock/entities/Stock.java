package com.flavio.easystock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Stock {

    @Id
    @Column(name = "product_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", nullable = false, updatable = false, unique = true)
    private Product product;

    @Setter
    @Column(nullable = false)
    private int quantity = 0;

    @Setter
    @Column(nullable = false)
    private BigDecimal unitPrice = BigDecimal.valueOf(0.0);
}
