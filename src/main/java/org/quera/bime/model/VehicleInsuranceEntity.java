package org.quera.bime.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles_insurance")
@DiscriminatorValue("VEHICLE")
public class VehicleInsuranceEntity extends InsuranceEntity {
	// Code here :)

    @Column(name = "usage")
    private String usage;

    public VehicleInsuranceEntity() {
    }

    public VehicleInsuranceEntity(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        return usage;
    }

    public VehicleInsuranceEntity setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() +
                "usage='" + usage ;
    }
}
