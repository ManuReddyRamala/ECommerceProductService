package com.example.productservice.Model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity

public class Category extends BaseModel {


    private String title;


}
