package org.quera.bime.data;

public class VehicleInsuranceDto extends InsuranceDto {


    private String usage;

    public VehicleInsuranceDto() {
    }

    public VehicleInsuranceDto(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        return usage;
    }

    public VehicleInsuranceDto setUsage(String usage) {
        this.usage = usage;
        return this;
    }
}
