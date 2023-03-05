package org.quera.bime.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons_insurance")
@DiscriminatorValue("PERSON")
public class PersonInsuranceEntity extends InsuranceEntity {
	// Code here :)
    @Column(name = "min_age")
    private int minAge;

    public PersonInsuranceEntity() {
    }

    public PersonInsuranceEntity(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public PersonInsuranceEntity setMinAge(int minAge) {
        this.minAge = minAge;
        return this;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "minAge=" + minAge ;
    }
}
