package com.example.productservice.Service;

import com.example.productservice.Model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    public Product getProductById(@PathVariable("id") Long id);
    public List<Product> getAllProducts();
    public Product createProduct(Product product);


}
