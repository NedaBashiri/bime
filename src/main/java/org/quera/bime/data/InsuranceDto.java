package org.quera.bime.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
property = "type"
        ,visible = false)
@JsonSubTypes({
        @Type(value = PersonInsuranceDto.class,name = "PERSON"),
        @Type(value = VehicleInsuranceDto.class, name = "VEHICLE")
})

public class InsuranceDto {

    private String   name;

    private Double  price;
    @JsonProperty ("company_id")
    private long companyId;
    @JsonIgnore
    private InsuranceType type;

    public InsuranceDto() {
    }

    public String getName() {
        return name;
    }

    public InsuranceDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public InsuranceDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public InsuranceDto setCompanyId(long companyId) {
        this.companyId = companyId;
        return this;
    }

    public InsuranceType getType() {
        return type;
    }

    public InsuranceDto setType(InsuranceType type) {
        this.type = type;
        return this;
    }
}
