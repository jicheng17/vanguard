package com.jaycee.backend.service;

import com.jaycee.backend.domain.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
}
