package com.example.productservice.Service;

import com.example.productservice.Model.Category;
import com.example.productservice.Model.Product;
import com.example.productservice.Repo.CategoryRepo;
import com.example.productservice.Repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class eProductService implements ProductService{
    ProductRepo pr;
    CategoryRepo cr;
    eProductService(ProductRepo pr, CategoryRepo cr)
    {
        this.pr=pr;
        this.cr=cr;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct=pr.findById(id);
        if(optionalProduct.isEmpty())
        {
            throw  new RuntimeException("Product Not Found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
//        Before saving Product we need
//        to create category in db

        Category c=product.getCategory();
        if(c!=null && c.getId()==null)
        {
            Category savedCategory= cr.save(c);
            product.setCategory(savedCategory);
        }


        Product savepr=pr.save(product);

        return savepr;
    }
}
