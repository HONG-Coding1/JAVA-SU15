//package com.setec.javasu15.Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.jspecify.annotations.NonNull;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.setec.javasu15.model.Entity.Product;
//
//
//
//@RestController
//@RequestMapping("/api/v2/products")
//public class ProductController implements CommandLineRunner {
//
//    private final List<Product> products = new ArrayList<>();
//
//    @Override
//        public void run(String @NonNull ... args) throws Exception {
//            products.add(new Product(1L, "Laptop", "A high-performance laptop", 999.99));
//            products.add(new Product(2L, "Smartphone", "A latest model smartphone", 799.99));
//            products.add(new Product(3L, "Headphones", "Noise-cancelling headphones", 199.99));
//        }
//
//    @GetMapping
//    public List<Product> list() {
//        return products;
//    }
//
//    @GetMapping("/{id}")
//    public Product getById(@PathVariable Long id) {
//        for(Product product : products) {
//            if(product.getId().equals(id)) {
//                return product;
//            }
//        }
//        throw new IllegalArgumentException("Product not found");
//    }
//
//    @PostMapping
//    public Product create(@RequestBody Product product) {
//        for(Product p : products) {
//            if(p.getId().equals(product.getId())) {
//                throw new IllegalArgumentException("Product with this ID already exists");
//            }
//        }
//        products.add(product);
//        return product;
//    }
//
//    @PutMapping("/{id}")
//    public Product update(@PathVariable Long id, @RequestBody Product updatedProduct) {
//        for(Product product : products) {
//            if(product.getId().equals(id)) {
//                product.setName(updatedProduct.getName());
//                product.setDescription(updatedProduct.getDescription());
//                product.setPrice(updatedProduct.getPrice());
//                return product;
//            }
//        }
//        throw new IllegalArgumentException("Product not found");
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        products.removeIf(product -> product.getId().equals(id));
//    }
//
//}
