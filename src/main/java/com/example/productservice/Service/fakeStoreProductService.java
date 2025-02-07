package com.example.productservice.Service;

import com.example.productservice.Dto.FakeStoreRequestDto;
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

    @Override
    public Product createProduct(Product product) {
        FakeStoreRequestDto frdto = new FakeStoreRequestDto();
        frdto=convertProductToFakeStoreRequestDto(product);

        FakeStoreResponseDto fdto=restTemplate.postForObject("https://fakestoreapi.com/products",frdto,FakeStoreResponseDto.class);

        return convertFakeStoreDtoToProduct(fdto);
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
        p.setCategory(c);

        return p;

    }
    public FakeStoreRequestDto convertProductToFakeStoreRequestDto(Product p)
    {
        FakeStoreRequestDto fdto = new FakeStoreRequestDto();
        fdto.setTitle(p.getTitle());
        fdto.setDescription(p.getDescription());
        fdto.setPrice(p.getPrice());
        fdto.setImage(p.getImage());
        fdto.setCategory(p.getCategory().getTitle());
        return fdto;
    }
}
