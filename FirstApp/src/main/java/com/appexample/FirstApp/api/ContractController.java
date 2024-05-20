package com.appexample.FirstApp.api;

import com.appexample.FirstApp.domain.contract.Contract;
import com.appexample.FirstApp.domain.contract.ContractRepository;
import com.appexample.FirstApp.domain.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractController {

final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/test")
    public String productTest() {
        return "<h1>testare</h1>";
    }

    @GetMapping("/contracts")
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @GetMapping("/contracts/{id}")
    Contract getById(@PathVariable Integer id) {
        return contractRepository.findById(id).get();
    }
}
