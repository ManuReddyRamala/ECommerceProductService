package com.example.productservice.Service;

import com.example.productservice.Model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

    public Product getProductById(@PathVariable("id") Long id);
    public List<Product> getAllProducts();


}
