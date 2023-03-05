package org.quera.bime.service;

import org.quera.bime.data.*;
import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.InsuranceEntity;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository ;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void save(CompanyDto companyDto ){
        CompanyEntity company = new CompanyEntity();
        company.setName(companyDto.getName());
        companyRepository.save(company);
    }

    public CompanyDto get(Long id){
        Optional<CompanyEntity> company = companyRepository.findById(id);
        if (!company.isPresent()) {
            throw new IllegalArgumentException("company not found for id: " + id);
        }
        CompanyEntity companyEntity = company.get();
        CompanyDto companyDto = new CompanyDto();
        List<InsuranceDto> list = new ArrayList<>();
        companyDto.setName(companyEntity.getName());

        for (InsuranceEntity insurance : companyEntity.getInsurances()) {
            if (insurance.getType().equals(InsuranceType.PERSON)){
                PersonInsuranceEntity personInsuranceEntity = (PersonInsuranceEntity) insurance;
                PersonInsuranceDto personInsuranceDto = new PersonInsuranceDto();
                personInsuranceDto.setCompanyId(personInsuranceEntity.getCompany().getId());
                personInsuranceDto.setName(personInsuranceEntity.getName());
                personInsuranceDto.setPrice(personInsuranceEntity.getPrice());
                personInsuranceDto.setType(personInsuranceEntity.getType());
                personInsuranceDto.setMinAge(personInsuranceEntity.getMinAge());
                list.add(personInsuranceDto);
            }else {
                VehicleInsuranceEntity vehicleInsuranceEntity = (VehicleInsuranceEntity) insurance;
                VehicleInsuranceDto vehicleInsuranceDto = new VehicleInsuranceDto();
                vehicleInsuranceDto.setCompanyId(vehicleInsuranceEntity.getCompany().getId());
                vehicleInsuranceDto.setName(vehicleInsuranceEntity.getName());
                vehicleInsuranceDto.setPrice(vehicleInsuranceEntity.getPrice());
                vehicleInsuranceDto.setType(vehicleInsuranceEntity.getType());
                vehicleInsuranceDto.setUsage(vehicleInsuranceEntity.getUsage());
                list.add(vehicleInsuranceDto);
            }
        }
        companyDto.setInsurances(list);
        return companyDto;
    }
}
