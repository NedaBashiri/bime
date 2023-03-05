package org.quera.bime.service;

import org.quera.bime.data.InsuranceDto;
import org.quera.bime.data.InsuranceType;
import org.quera.bime.data.PersonInsuranceDto;
import org.quera.bime.data.VehicleInsuranceDto;
import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.InsuranceEntity;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.repository.CompanyRepository;
import org.quera.bime.repository.InsuranceRepository;
import org.quera.bime.repository.PersonInsuranceRepository;
import org.quera.bime.repository.VehicleInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceService {

    private final CompanyRepository companyRepository;

    private final InsuranceRepository insuranceRepository;

    private final PersonInsuranceRepository personInsuranceRepository;

    private final VehicleInsuranceRepository vehicleInsuranceRepository;

    @Autowired
    public InsuranceService(CompanyRepository companyRepository, InsuranceRepository insuranceRepository, PersonInsuranceRepository personInsuranceRepository, VehicleInsuranceRepository vehicleInsuranceRepository) {
        this.companyRepository = companyRepository;
        this.insuranceRepository = insuranceRepository;
        this.personInsuranceRepository = personInsuranceRepository;
        this.vehicleInsuranceRepository = vehicleInsuranceRepository;
    }


    public void save(InsuranceDto insuranceDto) {
        Optional<CompanyEntity> company = companyRepository.findById(insuranceDto.getCompanyId());
        if (!company.isPresent()) {
            throw new IllegalArgumentException("company not found for id: " + insuranceDto.getCompanyId());
        }
        if (insuranceDto instanceof PersonInsuranceDto) {
            PersonInsuranceDto personInsuranceDto = (PersonInsuranceDto) insuranceDto;
            PersonInsuranceEntity personInsuranceEntity = new PersonInsuranceEntity();
            personInsuranceEntity.setCompany(company.get());
            personInsuranceEntity.setPrice(personInsuranceDto.getPrice());
            personInsuranceEntity.setName(personInsuranceDto.getName());
            personInsuranceEntity.setMinAge(personInsuranceDto.getMinAge());
            personInsuranceRepository.save(personInsuranceEntity);
        }else if (insuranceDto instanceof VehicleInsuranceDto){
            VehicleInsuranceDto vehicleInsuranceDto = (VehicleInsuranceDto) insuranceDto;
            VehicleInsuranceEntity vehicleInsuranceEntity = new VehicleInsuranceEntity();
            vehicleInsuranceEntity.setCompany(company.get());
            vehicleInsuranceEntity.setPrice(vehicleInsuranceDto.getPrice());
            vehicleInsuranceEntity.setName(vehicleInsuranceDto.getName());
            vehicleInsuranceEntity.setUsage(vehicleInsuranceDto.getUsage());
            vehicleInsuranceRepository.save(vehicleInsuranceEntity);
        }

    }

    public InsuranceDto get(Long id) {
        Optional<InsuranceEntity> insurance = insuranceRepository.findById(id);
        if (!insurance.isPresent()){
            throw new IllegalArgumentException("insurance not found for id: " + id);
        }
        InsuranceEntity insuranceEntity = insurance.get();
        if (insuranceEntity.getType().equals(InsuranceType.PERSON)) {
            PersonInsuranceEntity personInsuranceEntity = (PersonInsuranceEntity) insuranceEntity;
            PersonInsuranceDto personInsuranceDto = new PersonInsuranceDto();
                personInsuranceDto.setName(personInsuranceEntity.getName());
                personInsuranceDto.setPrice(personInsuranceEntity.getPrice());
                /*personInsuranceDto.setType(personInsuranceEntity.getType());*/
                personInsuranceDto.setCompanyId(personInsuranceEntity.getCompany().getId());
                personInsuranceDto.setMinAge(personInsuranceEntity.getMinAge());
           return personInsuranceDto;

        }else {
            VehicleInsuranceEntity vehicleInsuranceEntity = (VehicleInsuranceEntity) insuranceEntity;
            VehicleInsuranceDto vehicleInsuranceDto = new VehicleInsuranceDto();
            vehicleInsuranceDto.setName(vehicleInsuranceEntity.getName());
            vehicleInsuranceDto.setPrice(vehicleInsuranceEntity.getPrice());
            /*vehicleInsuranceDto.setType(vehicleInsuranceEntity.getType());*/
            vehicleInsuranceDto.setCompanyId(vehicleInsuranceEntity.getCompany().getId());
            vehicleInsuranceDto.setUsage(vehicleInsuranceEntity.getUsage());
            return vehicleInsuranceDto;
        }

    }
}
