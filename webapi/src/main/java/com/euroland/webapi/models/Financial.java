package com.euroland.webapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Financials")
public class Financial {
    @Id
    private String id;
    private String name;
    private Company company;
    private List<FinancialDetail> financialDetails;

    protected Financial(){
        this.financialDetails = new ArrayList<>();
    }

    public Financial( String name, Company company, List<FinancialDetail> financialDetails) {
        this.name = name;
        this.company = company;
        this.financialDetails = financialDetails;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<FinancialDetail> getFinancialDetails() {
        return financialDetails;
    }

    public void setFinancialDetails(List<FinancialDetail> financialDetails) {
        this.financialDetails = financialDetails;
    }
}
