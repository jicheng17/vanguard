package com.jaycee.backend.service;

import com.jaycee.backend.domain.Product;
import com.jaycee.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return (Product)productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductById(String id){
        List<String> ids = new ArrayList<>();
        ids.add(id);

        Iterable<Product> iterable = productRepository.findAllById(ids);

        List<Product> productList = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());

        return productList;
    }
}
