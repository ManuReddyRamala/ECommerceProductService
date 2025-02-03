package com.example.productservice.Service;

import com.example.productservice.Dto.FakeStoreResponseDto;
import com.example.productservice.Model.Category;
import com.example.productservice.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProductById(Long id) {

        Product p = new Product();

        FakeStoreResponseDto fdto =restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);



        return convertFakeStoreDtoToProduct(fdto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreResponseDto[] fdto =restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreResponseDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreResponseDto dto : fdto) {
            Product p = new Product();
            p=convertFakeStoreDtoToProduct(dto);
            products.add(p);
        }
        return products;
    }

    public Product convertFakeStoreDtoToProduct(FakeStoreResponseDto fdto)
    {
        Product p=new Product();
        p.setId(fdto.getId());
        p.setDescription(fdto.getDescription());
        p.setPrice(fdto.getPrice());
        p.setTitle(fdto.getTitle());
        p.setImage(fdto.getImage());
        Category c=new Category();
        c.setTitle(fdto.getCategory());
        c.setId(fdto.getRate());
        p.setCategory(c);

        return p;

    }
}
