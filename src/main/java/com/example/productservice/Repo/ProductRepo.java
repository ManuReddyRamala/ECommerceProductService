package com.example.productservice.Repo;

import com.example.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);
    Optional<Product> findByTitle( String title);

//    select* from Product where title="" and Description=""
    List<Product> findByTitleAndDescription(String title, String desc);

//    To save or upsert we use "save"
   Product save(Product product);

//   HQL(Hibernate Query Language) query
    @Query("select p.title, p.description from Product p where p.id=:id")
    Product CustomQuery(Long id);
}
