package org.quera.bime.data;

import java.util.List;

public class CompanyDto {
    private String name;
    private List<InsuranceDto> insurances;

    public CompanyDto() {
    }

    public CompanyDto(String name, List<InsuranceDto> insurances) {
        this.name = name;
        this.insurances = insurances;
    }

    public String getName() {
        return name;
    }

    public CompanyDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<InsuranceDto> getInsurances() {
        return insurances;
    }

    public CompanyDto setInsurances(List<InsuranceDto> insurances) {
        this.insurances = insurances;
        return this;
    }
}
