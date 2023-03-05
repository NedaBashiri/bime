package org.quera.bime.model;

import org.hibernate.annotations.CreationTimestamp;
import org.quera.bime.data.InsuranceType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurances")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class InsuranceEntity {
    // Code here :)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
     @Enumerated(value = EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private InsuranceType type;
    @ManyToOne
    @JoinColumn
    private CompanyEntity company;


    public InsuranceEntity() {
    }

    public InsuranceEntity(Long id, String name, Double price, LocalDateTime created_at, CompanyEntity company, InsuranceType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = created_at;
        this.company = company;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public InsuranceEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public InsuranceEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public InsuranceEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public InsuranceEntity setCreatedAt(LocalDateTime created_at) {
        this.createdAt = created_at;
        return this;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public InsuranceEntity setCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }


    public InsuranceType getType() {
        return type;
    }

    public InsuranceEntity setType(InsuranceType type) {
        this.type = type;
        return this;
    }

}

