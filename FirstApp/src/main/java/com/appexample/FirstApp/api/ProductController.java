package com.appexample.FirstApp.api;

import com.appexample.FirstApp.api.DTO.ProductDtoAdd;
import com.appexample.FirstApp.api.DTO.ProductDtoUpdate;
import com.appexample.FirstApp.domain.product.Product;
import com.appexample.FirstApp.domain.product.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * POST/CREATE endpoint
     */
    @PostMapping("/add")
    Product add(@RequestBody ProductDtoAdd commandDto) {
        Product editProduct = new Product();
        editProduct.setName(commandDto.getName());
        editProduct.setVAT(commandDto.getVAT());
        editProduct.setPriceWithoutVAT(commandDto.getPriceWithoutVAT());
        editProduct.setPriceWithVat(commandDto.getPriceWithVat());
        return productRepository.save(editProduct);
    }

    /**
     * UPDATE endpoint
     */
    @PostMapping("/update/{id}")
    Product update(
            @PathVariable Integer id,
            @RequestBody ProductDtoUpdate updateDto){
        Product productUpdated = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nu exista produsul cu id-ul"+id));


        productUpdated.setName(updateDto.getName());
        productUpdated.setPriceWithoutVAT(updateDto.getPriceWithoutVAT());
        productUpdated.setVAT(updateDto.getVAT());
        productUpdated.setPriceWithVat(updateDto.getPriceWithVat());

        return productRepository.save(productUpdated);
    }


    /** DELETE endpoint */


    /** GET/READ endpoint */
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Product getById(@PathVariable Integer id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/test")
    public String productTest() {
        return "<h1>testing</h1>";
    }

    @GetMapping
    public String productString() {
        return "product String";
    }


}
