package com.appexample.FirstApp.api;

import com.appexample.FirstApp.api.DTO.ProductDtoAdd;
import com.appexample.FirstApp.api.DTO.ProductDtoUpdate;
import com.appexample.FirstApp.domain.product.Product;
import com.appexample.FirstApp.domain.product.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appexample.FirstApp.api.exception.BadRequestException;

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
            @RequestBody ProductDtoUpdate updateDto) throws BadRequestException {
        Product productUpdated = productRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul: " + id));
        /** verificare calcule price/vat */

        if (updateDto.getPriceWithoutVAT() + updateDto.getVAT() != updateDto.getPriceWithVat()) {
            throw new BadRequestException("Pretul fara tva+tva nu corespunde nu pretul cu tva!");
        }

        productUpdated.setName(updateDto.getName());
        productUpdated.setPriceWithoutVAT(updateDto.getPriceWithoutVAT());
        productUpdated.setVAT(updateDto.getVAT());
        productUpdated.setPriceWithVat(updateDto.getPriceWithVat());

        return productRepository.save(productUpdated);
    }

    /**
     * Discount utilizator
     */

    @PostMapping("/checkout/discount/{id}")
    Product discount(@PathVariable Integer id,
                     @RequestParam String discount) {
        Product productDiscount = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul: " + id));

        double procentDiscount = 0;
        if (discount == null || !discount.equals("java")) {
            procentDiscount = 1;
        } else {
            procentDiscount = (double) 50 / 100;
        }
        productDiscount.setPriceWithoutVAT((int) (productDiscount.getPriceWithoutVAT() * procentDiscount));
        productDiscount.setPriceWithVat((int) (productDiscount.getPriceWithVat() * procentDiscount));
        productDiscount.setVAT((int) (productDiscount.getVAT() * procentDiscount));


        return productDiscount;

    }


    /**
     * DELETE endpoint
     */
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        Product productToBeDeleted = productRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul: " + id));
        productRepository.delete(productToBeDeleted);
        return ResponseEntity.ok("The product have been deleted.");
    }


    /**
     * GET/READ endpoint
     */
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
