package com.flavio.easystock.dtos.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductTypeIdRequest {

    @Min(1)
    private Long id;
}
