package org.quera.bime.repository;


import org.quera.bime.model.PersonInsuranceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInsuranceRepository extends CrudRepository<PersonInsuranceEntity, Long> {
}
