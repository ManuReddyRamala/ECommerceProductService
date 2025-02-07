package com.example.productservice.Service;

import com.example.productservice.Model.Product;

import java.util.List;

public class eProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
