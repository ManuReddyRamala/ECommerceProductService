package com.example.productservice.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product  extends BaseModel{


    private String title;
    private Double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;

}
