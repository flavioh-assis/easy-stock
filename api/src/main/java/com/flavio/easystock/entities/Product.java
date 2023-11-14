package com.flavio.easystock.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flavio.easystock.dtos.requests.ProductRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JsonIgnoreProperties("products")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private ProductType type;

    public Product(ProductRequest request, ProductType type) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.type = type;
    }
}
