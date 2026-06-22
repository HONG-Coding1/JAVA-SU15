package com.setec.javasu15.service.serviceImpl;

import com.setec.javasu15.model.Entity.Product;
import com.setec.javasu15.model.request.ProductRequest;
import com.setec.javasu15.model.response.ProductResponse;
import com.setec.javasu15.repository.ProductRepository;
import com.setec.javasu15.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> list(int page, int size, String name) {
        if (page < 1 || size < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Page and size must be greater than 0");
        }

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Product> products;

        if (name != null && !name.isBlank()) {
            products = productRepository.findByNameContaining(name, pageable);
        } else {
            products = productRepository.findAll(pageable);
        }

        return products
                .stream()
                .map(Product::toResponse)
                .toList();
    }

    @Override
    public ProductResponse get(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"))
                .toResponse();
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        return productRepository.save(request.toProduct(null)).toResponse();
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));

        return productRepository.save(request.toProduct(id)).toResponse();
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }

        productRepository.deleteById(id);
    }
}
