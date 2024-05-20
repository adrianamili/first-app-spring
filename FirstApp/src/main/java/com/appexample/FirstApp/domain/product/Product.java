package com.appexample.FirstApp.domain.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int priceWithoutVAT;
    int VAT;
    int priceWithVat;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriceWithoutVAT() {
        return priceWithoutVAT;
    }

    public int getVAT() {
        return VAT;
    }

    public int getPriceWithVat() {
        return priceWithVat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceWithoutVAT(int priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public void setPriceWithVat(int priceWithVat) {
        this.priceWithVat = priceWithVat;
    }
}
