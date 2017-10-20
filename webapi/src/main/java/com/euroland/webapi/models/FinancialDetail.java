package com.euroland.webapi.models;

import java.util.Date;

public class FinancialDetail {
    private double financialValue;
    private String year;

    public FinancialDetail(double financialValue, String year) {
        this.financialValue = financialValue;
        this.year = year;
    }

    public double getFinancialValue() {
        return financialValue;
    }

    public void setFinancialValue(double financialValue) {
        this.financialValue = financialValue;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
