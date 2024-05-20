package com.appexample.FirstApp.api.DTO;

public class CarDtoAdd {

    int id;
    String brand;
    String model;
    int year;
    int powerCouple;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPowerCouple() {
        return powerCouple;
    }

    public void setPowerCouple(int powerCouple) {
        this.powerCouple = powerCouple;
    }
}
