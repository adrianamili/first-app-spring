package com.appexample.FirstApp.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
