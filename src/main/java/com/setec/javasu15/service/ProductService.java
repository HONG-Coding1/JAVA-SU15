package com.setec.javasu15.service;

import com.setec.javasu15.model.request.ProductRequest;
import com.setec.javasu15.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> list(int page, int size, String name);

    ProductResponse get(Long id);

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);
}
