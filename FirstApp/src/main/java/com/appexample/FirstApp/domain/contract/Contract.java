package com.appexample.FirstApp.domain.contract;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    String contractName;
    String type;
    Date contractDate;
    String paymentTerms;

    public int getId() {
        return id;
    }

    public String getContractName() {
        return contractName;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public String getType() {
        return type;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
}
