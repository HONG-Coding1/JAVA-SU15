package com.setec.javasu15.model.request;

import com.setec.javasu15.model.Entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @PositiveOrZero(message = "Price must be zero or greater")
    private double price;

    public Product toProduct(Long id) {
        return new Product(id, name, description, price);
    }
}
