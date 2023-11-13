package com.flavio.easystock.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductTypeRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must have a maximum of 255 characters.")
    private String name;
}
