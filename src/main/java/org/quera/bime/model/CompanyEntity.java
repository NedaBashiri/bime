package org.quera.bime.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {
	// Code here :)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "company")
    private List<InsuranceEntity> insurances;

    public CompanyEntity() {
    }

    public CompanyEntity(Long id, String name, List<InsuranceEntity> insurances) {
        this.id = id;
        this.name = name;
        this.insurances = insurances;
    }


    public Long getId() {
        return id;
    }

    public CompanyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<InsuranceEntity> getInsurances() {
        return insurances;
    }

    public CompanyEntity setInsurances(List<InsuranceEntity> insurances) {
        this.insurances = insurances;
        return this;
    }

}
