package com.example.productservice.Dto;

import lombok.Data;

@Data
public class FakeStoreResponseDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    private String category;
    private double rate;
}
