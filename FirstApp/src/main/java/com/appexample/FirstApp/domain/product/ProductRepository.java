package com.appexample.FirstApp.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("""
            SELECT p FROM Product p
            """)
    List<Product> findAllProducts();


    @Query("""
            SELECT p FROM Product p WHERE p.CATEGORY_ID = :categoryId
            """)
    List<Product> findAllByCategoryId(Long categoryId);

}
