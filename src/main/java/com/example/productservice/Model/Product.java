package com.example.productservice.Model;


import lombok.Data;

@Data
public class Product {

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;

}
