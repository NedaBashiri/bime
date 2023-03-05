package org.quera.bime.controllers;

import org.quera.bime.data.CompanyDto;
import org.quera.bime.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody CompanyDto company ){
        try {
            companyService.save(company);
            return ResponseEntity.ok("Company saved.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Company saving problem!");
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<CompanyDto> save(@PathVariable Long id ){

            CompanyDto company = companyService.get(id);

            return ResponseEntity.ok(company);
    }
}
