package com.appexample.FirstApp.api.productController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController2 {
    @GetMapping("/product2")
    public String product2(){
        return "product 2 din ProductController2";
    }
}
