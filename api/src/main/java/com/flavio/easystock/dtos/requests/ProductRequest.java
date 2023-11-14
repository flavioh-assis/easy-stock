package com.flavio.easystock.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must have a maximum of 255 characters.")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must have a maximum of 255 characters.")
    private String description;

    @NotNull
    private ProductTypeIdRequest type;
}
