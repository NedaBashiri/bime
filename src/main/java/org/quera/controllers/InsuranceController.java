package org.quera.controllers;

import org.quera.bime.data.InsuranceDto;
import org.quera.bime.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
    @Autowired
    InsuranceService insurance;

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody InsuranceDto insuranceDto ){
        try {
            insurance.save(insuranceDto);
            return ResponseEntity.ok("insurance saved.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("insurance saving problem!");
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity get(@PathVariable Long id ){
        try {
            InsuranceDto insuranceDto = insurance.get(id);
            return ResponseEntity.ok(insuranceDto);
        }catch (Exception e){
            return ResponseEntity.ok("Insurance not found!");
        }

    }
}
