package org.quera.bime.data;

public class PersonInsuranceDto extends InsuranceDto {

    private int minAge;

    public PersonInsuranceDto() {
    }

    public PersonInsuranceDto(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public PersonInsuranceDto setMinAge(int minAge) {
        this.minAge = minAge;
        return this;
    }
}
