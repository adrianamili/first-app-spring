package com.appexample.FirstApp.api.DTO;

import jakarta.validation.constraints.NotEmpty;

public class ProductDtoAdd {

    @NotEmpty(message = "Trebuie completat numele produsului!")
    String name;
    int priceWithoutVAT;
    int VAT;
    int priceWithVat;

    public int getPriceWithoutVAT() {
        return priceWithoutVAT;
    }

    public void setPriceWithoutVAT(int priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public int getPriceWithVat() {
        return priceWithVat;
    }

    public void setPriceWithVat(int priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
