package com.appexample.FirstApp.api;

import com.appexample.FirstApp.api.DTO.CarDtoAdd;
import com.appexample.FirstApp.api.DTO.ProductDtoAdd;
import com.appexample.FirstApp.domain.car.Car;
import com.appexample.FirstApp.domain.car.CarRepository;
import com.appexample.FirstApp.domain.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/add")
    Car add(@RequestBody CarDtoAdd commandDto) {
        Car editCar = new Car();
        editCar.setBrand(commandDto.getBrand());
        editCar.setModel(commandDto.getModel());
        editCar.setYear(commandDto.getYear());
        editCar.setPowerCouple(commandDto.getPowerCouple());
        return carRepository.save(editCar);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    Car getById(@PathVariable Integer id) {
        return carRepository.findById(id).get();
    }
}
