package com.flavio.easystock.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private ProductTypeResponse type;
}
