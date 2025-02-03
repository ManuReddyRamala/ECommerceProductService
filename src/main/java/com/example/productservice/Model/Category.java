package com.example.productservice.Model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;

@Data
public class Category {

    private double id;
    private String title;

    public Double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
