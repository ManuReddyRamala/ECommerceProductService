package com.example.productservice.Model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
@Data

@MappedSuperclass
public class BaseModel {

    @Id
    private long id;

    private Date created_at;
    private Date updated_at;
}
